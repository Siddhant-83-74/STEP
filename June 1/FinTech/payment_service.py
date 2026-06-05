# payment_service.py
from otp_service import OtpService

class PaymentService:
    def __init__(self, account_repo, otp_service: OtpService):
        self.account_repo = account_repo
        self.otp_service = otp_service

    def process_payment(self, user_id: str, amount: float, otp: str = None) -> str:
        # Rule 1: Amount must be positive
        if amount <= 0:
            return "FAILED: Invalid amount"

        # Rule 2: OTP mandatory for payments > ₹2000 (RBI mandate)
        if amount > 2000:
            if not self.otp_service.validate_otp(user_id, otp):
                return "FAILED: Invalid or expired OTP"

        # Rule 3: Check account balance
        account = self.account_repo.find_by_user_id(user_id)
        if account is None:
            raise ValueError(f"Account not found: {user_id}")

        if account.balance < amount:
            return "FAILED: Insufficient balance"

        # Deduct and save
        account.balance -= amount
        self.account_repo.save(account)
        return f"SUCCESS: Payment of ₹{amount} processed"