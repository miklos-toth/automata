package service

import model.Method
import model.Method.BANK_TRANSFER
import model.Method.CARD
import model.Method.SMS
import model.ProcessingBankTransfer
import model.ProcessingCard
import model.ProcessingSms
import model.Status
import model.Status.Initial
import model.Status.Paid
import model.Status.Processing
import model.bankTransferExample
import model.cardExample
import model.paymentExample
import model.smsExample

class PaymentAutomata {
    private val payment = paymentExample

    fun selectMethod(method: Method) =
        when (payment.status) {
            is Paid -> payment.status
            is Initial -> startProcessing(method)
            is Processing -> startProcessing(method)
        }

    fun pay(method: Method) =
        when (payment.status) {
            is Paid, is Initial -> payment.status
            is Processing -> executePayment(method)
        }

    private fun startProcessing(method: Method): Processing {
        val status = when (method) {
            BANK_TRANSFER -> ProcessingBankTransfer(bankTransferExample)
            SMS -> ProcessingSms(smsExample)
            CARD -> ProcessingCard(cardExample)
        }
        payment.processing.add(status)
        return status
    }

    private fun executePayment(method: Method): Status {
        val processing = findProcessing(method)?.let {
            val status = when (method) {
                BANK_TRANSFER -> ProcessingBankTransfer(bankTransferExample)
                SMS -> ProcessingSms(smsExample)
                CARD -> ProcessingCard(cardExample)
            }
        }
        return payment.status
    }

    private fun findProcessing(method: Method): Processing? {
        for (processing in payment.processing) {
            if (processing.method == method)
                return processing
        }
        return null
    }


}