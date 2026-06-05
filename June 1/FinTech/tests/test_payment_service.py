import pytest
from unittest.mock import MagicMock, patch
from models import Account
from payment_service import PaymentService


@pytest.fixture
def mock_account_repo():
    """Fake account repository — no real DB."""
    return MagicMock()


@pytest.fixture
def mock_otp_service():
    """Fake OTP service — no real Redis."""
    return MagicMock()


@pytest.fixture
def payment_service(mock_account_repo, mock_otp_service):
    return PaymentService(
        account_repo=mock_account_repo,
        otp_service=mock_otp_service
    )


class TestPaymentUnder2000:

    def test_payment_under_2000_succeeds_without_otp(
        self, payment_service, mock_account_repo, mock_otp_service
    ):
        """Payment ≤ ₹2000 → no OTP check, deduct balance."""
        # ARRANGE
        fake_account = Account("user123", 5000.0, "user@email.com")
        mock_account_repo.find_by_user_id.return_value = fake_account

        # ACT
        result = payment_service.process_payment("user123", 1500.0)

        # ASSERT
        assert result == "SUCCESS: Payment of ₹1500.0 processed"
        assert fake_account.balance == 3500.0
        mock_otp_service.validate_otp.assert_not_called()  # OTP never checked

    def test_balance_saved_after_payment(
        self, payment_service, mock_account_repo
    ):
        """Account must be saved after successful payment."""
        fake_account = Account("user123", 5000.0, "user@email.com")
        mock_account_repo.find_by_user_id.return_value = fake_account

        payment_service.process_payment("user123", 500.0)

        mock_account_repo.save.assert_called_once_with(fake_account)


class TestPaymentOver2000:

    def test_payment_over_2000_with_valid_otp_succeeds(
        self, payment_service, mock_account_repo, mock_otp_service
    ):
        """Payment > ₹2000 with valid OTP → should succeed."""
        # ARRANGE
        fake_account = Account("user123", 10000.0, "user@email.com")
        mock_account_repo.find_by_user_id.return_value = fake_account
        mock_otp_service.validate_otp.return_value = True  # OTP is valid

        # ACT
        result = payment_service.process_payment("user123", 5000.0, "987654")

        # ASSERT
        assert result == "SUCCESS: Payment of ₹5000.0 processed"
        assert fake_account.balance == 5000.0

    def test_payment_over_2000_with_invalid_otp_fails(
        self, payment_service, mock_account_repo, mock_otp_service
    ):
        """Payment > ₹2000 with wrong OTP → early return, DB never touched."""
        mock_otp_service.validate_otp.return_value = False  # OTP invalid

        result = payment_service.process_payment("user123", 5000.0, "000000")

        assert result == "FAILED: Invalid or expired OTP"
        mock_account_repo.find_by_user_id.assert_not_called()  # DB never called


class TestEdgeCases:

    def test_negative_amount_rejected(
        self, payment_service, mock_account_repo, mock_otp_service
    ):
        """Negative amounts must be rejected immediately."""
        result = payment_service.process_payment("user123", -100.0)

        assert result == "FAILED: Invalid amount"
        mock_account_repo.find_by_user_id.assert_not_called()
        mock_otp_service.validate_otp.assert_not_called()

    def test_zero_amount_rejected(self, payment_service):
        """Zero payment is also invalid."""
        result = payment_service.process_payment("user123", 0)
        assert result == "FAILED: Invalid amount"

    def test_insufficient_balance(
        self, payment_service, mock_account_repo
    ):
        """Payment must fail if account doesn't have enough funds."""
        fake_account = Account("user123", 100.0, "user@email.com")
        mock_account_repo.find_by_user_id.return_value = fake_account

        result = payment_service.process_payment("user123", 500.0)

        assert result == "FAILED: Insufficient balance"
        assert fake_account.balance == 100.0  # Balance unchanged
        mock_account_repo.save.assert_not_called()  # Save never called

    def test_account_not_found_raises_exception(
        self, payment_service, mock_account_repo
    ):
        """Missing account must raise ValueError, not return FAILED."""
        mock_account_repo.find_by_user_id.return_value = None

        with pytest.raises(ValueError, match="Account not found: ghost_user"):
            payment_service.process_payment("ghost_user", 500.0)