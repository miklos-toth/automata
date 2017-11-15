package model

import model.Status.Processing
import java.math.BigDecimal
import java.util.Currency

data class Payment(
    val amount: BigDecimal,
    val currency: Currency,
    val status: Status,
    val processing: HashSet<Processing>
)
val paymentExample: Payment = Payment(
    amount = BigDecimal.ONE,
    currency = Currency.getInstance("USD"),
    status = Status.Initial(),
    processing = HashSet()
)