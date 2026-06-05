# test_unit.py
import account_services

# ---------- Helpers ----------

# Fake database (replaces real database.py)
fake_db = {}

def fake_save(user_id, balance):
    fake_db[user_id] = balance

def fake_find(user_id):
    return fake_db.get(user_id)

def setup():
    # Swap real DB functions with fake ones before each test
    account_services.database.save = fake_save
    account_services.database.find = fake_find
    fake_db.clear()

# ---------- Tests ----------

def test_transfer_success():
    setup()
    fake_db["alice"] = 1000
    fake_db["bob"] = 500

    result = account_services.transfer("alice", "bob", 200)

    assert result == "SUCCESS"
    assert fake_db["alice"] == 800
    assert fake_db["bob"] == 700

def test_transfer_insufficient_balance():
    setup()
    fake_db["alice"] = 100
    fake_db["bob"] = 500

    result = account_services.transfer("alice", "bob", 999)

    assert result == "FAILED: Insufficient balance"
    assert fake_db["alice"] == 100   # unchanged
    assert fake_db["bob"] == 500     # unchanged

def test_transfer_invalid_amount():
    setup()
    result = account_services.transfer("alice", "bob", -50)
    assert result == "FAILED: Invalid amount"

def test_transfer_sender_not_found():
    setup()
    # alice doesn't exist in fake_db
    fake_db["bob"] = 500

    result = account_services.transfer("alice", "bob", 100)
    assert result == "FAILED: Sender not found"

def test_create_account_negative_balance():
    setup()
    try:
        account_services.create_account("alice", -500)
        assert False, "Should have raised ValueError"
    except ValueError:
        pass

# ---------- Run ----------

if __name__ == "__main__":
    tests = [
        test_transfer_success,
        test_transfer_insufficient_balance,
        test_transfer_invalid_amount,
        test_transfer_sender_not_found,
        test_create_account_negative_balance,
    ]

    for test in tests:
        try:
            test()
            print(f"PASS — {test.__name__}")
        except AssertionError as e:
            print(f"FAIL — {test.__name__}: {e}")