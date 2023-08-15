package com.deliveryhero.paymentgateway.models.requests

import com.deliveryhero.paymentgateway.models.PaymentInstrument
import com.deliveryhero.paymentgateway.models.enums.OperationType

data class TokenizeRequest(
    val paymentInstrument: PaymentInstrument,
    override val paymentTransactionId: String
) : BaseRequest(paymentTransactionId)
