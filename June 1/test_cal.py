import database

def create_account(user_id, initial_balance):
    if initial_balance < 0:
        raise ValueError("Balance cannot be negative")
    database.save(user_id, initial_balance)

def get_balance(user_id):
    balance = database.find(user_id)
    if balance is None:
        raise ValueError("Account not found")
    return balance

def transfer(sender_id, receiver_id, amount):
    if amount <= 0:
        return "FAILED: Invalid amount"

    sender_balance = database.find(sender_id)
    if sender_balance is None:
        return "FAILED: Sender not found"

    receiver_balance = database.find(receiver_id)
    if receiver_balance is None:
        return "FAILED: Receiver not found"

    if sender_balance < amount:
        return "FAILED: Insufficient balance"

    database.save(sender_id, sender_balance - amount)
    database.save(receiver_id, receiver_balance + amount)
    return "SUCCESS"