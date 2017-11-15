package model

data class SmsPayment(
    val phoneNumber: String,
    val paymentReference: String)

val smsExample = SmsPayment(
    phoneNumber = "1234",
    paymentReference = "example reference"
)
