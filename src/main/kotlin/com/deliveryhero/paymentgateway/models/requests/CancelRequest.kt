package com.deliveryhero.paymentgateway.models.requests

import com.deliveryhero.paymentgateway.models.enums.OperationType

data class CancelRequest(
    override val paymentTransactionId: String
) : OperationPayload(OperationType.CAPTURE.name, paymentTransactionId)
