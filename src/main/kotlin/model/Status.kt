package model

import model.Method.BANK_TRANSFER
import model.Method.CARD
import model.Method.SMS
import model.Status.Processing

sealed class Status {
    class Initial : Status()
    open class Processing(val method: Method) : Status()
    class Paid : Status()
}

class ProcessingBankTransfer(val bankTransfer: BankTransferPayment) : Processing(BANK_TRANSFER)
class ProcessingSms(val smsPayment: SmsPayment) : Processing(SMS)
class ProcessingCard(val cardPayment: CardPayment) : Processing(CARD)

