import pytest
from unittest.mock import MagicMock, call
from otp_service import OtpService


@pytest.fixture
def mock_redis():
    """Returns a fake Redis client — no real Redis needed."""
    return MagicMock()


@pytest.fixture
def otp_service(mock_redis):
    return OtpService(redis_client=mock_redis)


class TestValidateOtp:

    def test_validate_otp_success(self, otp_service, mock_redis):
        """OTP matches → should return True."""
        # ARRANGE — fake Redis returns "123456"
        mock_redis.get.return_value = "123456"

        # ACT
        result = otp_service.validate_otp("user123", "123456")

        # ASSERT
        assert result is True
        mock_redis.get.assert_called_once_with("otp:user123")

    def test_validate_otp_wrong_code(self, otp_service, mock_redis):
        """Wrong OTP entered → should return False."""
        mock_redis.get.return_value = "123456"

        result = otp_service.validate_otp("user123", "999999")

        assert result is False

    def test_validate_otp_expired(self, otp_service, mock_redis):
        """OTP not in Redis (expired) → should return False."""
        mock_redis.get.return_value = None  # Key expired/not found

        result = otp_service.validate_otp("user123", "123456")

        assert result is False


class TestGenerateOtp:

    def test_generate_otp_stores_in_redis_with_ttl(self, otp_service, mock_redis):
        """Generated OTP must be stored in Redis with 5-minute TTL."""
        otp = otp_service.generate_otp("user123")

        # Verify Redis setex was called with correct key, TTL, and the OTP value
        mock_redis.setex.assert_called_once_with("otp:user123", 300, otp)

    def test_generate_otp_is_six_digits(self, otp_service, mock_redis):
        """OTP must always be exactly 6 digits."""
        for _ in range(20):  # Run 20 times to account for randomness
            otp = otp_service.generate_otp("user123")
            assert len(otp) == 6
            assert otp.isdigit()