package com.deliveryhero.paymentgateway.models.requests

import com.deliveryhero.paymentgateway.models.PaymentInstrumentDetails
import com.deliveryhero.paymentgateway.models.enums.OperationType

data class TokenizeRequest(
    val paymentInstrumentDetails: PaymentInstrumentDetails,
    override val paymentTransactionId: String
) : OperationPayload(OperationType.REFUND.name, paymentTransactionId)
