# otp_service.py
import random

class OtpService:
    def __init__(self, redis_client):
        self.redis = redis_client

    def generate_otp(self, user_id: str) -> str:
        otp = str(random.randint(100000, 999999))  # 6-digit OTP
        self.redis.setex(f"otp:{user_id}", 300, otp)  # 300s = 5 min TTL
        return otp

    def validate_otp(self, user_id: str, input_otp: str) -> bool:
        stored_otp = self.redis.get(f"otp:{user_id}")
        if stored_otp is None:
            return False  # Expired or not found
        return stored_otp == input_otp