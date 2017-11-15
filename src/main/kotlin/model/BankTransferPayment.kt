package model

data class BankTransferPayment(
    val accountHolder: String,
    val paymentReference: String,
    val bankName: String,
    val bankAccountNumber: String)

val bankTransferExample = BankTransferPayment(
    accountHolder = "Sample Account",
    paymentReference = "Example reference",
    bankName = "Bank",
    bankAccountNumber = "123456789123"
)