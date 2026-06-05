# models.py
from dataclasses import dataclass

@dataclass
class Account:
    user_id: str
    balance: float
    email: str