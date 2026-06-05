# Simulates a real database
accounts = {}

def save(user_id, balance):
    accounts[user_id] = balance

def find(user_id):
    return accounts.get(user_id)  # returns None if not found

def clear():
    accounts.clear()  # used to reset between tests