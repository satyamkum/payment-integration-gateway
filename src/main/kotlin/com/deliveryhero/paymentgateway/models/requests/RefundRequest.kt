package com.deliveryhero.paymentgateway.models.requests

import com.deliveryhero.paymentgateway.models.enums.OperationType

data class RefundRequest(
    override val paymentTransactionId: String
) : BaseRequest(paymentTransactionId)
