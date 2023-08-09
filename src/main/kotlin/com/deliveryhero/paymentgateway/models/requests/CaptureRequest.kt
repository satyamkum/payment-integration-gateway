package com.deliveryhero.paymentgateway.models.requests

import com.deliveryhero.paymentgateway.models.Money
import com.deliveryhero.paymentgateway.models.enums.OperationType

data class CaptureRequest(
    val amount: Money? = null,
    val paymentToken: String? = null,
    val platformReferenceId: String? = null,
    override val paymentTransactionId: String,
) : OperationPayload(OperationType.CAPTURE.name, paymentTransactionId)
