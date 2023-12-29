package com.deliveryhero.paymentgateway.models.requests

import com.deliveryhero.paymentgateway.models.enums.OperationStatus
import com.deliveryhero.paymentgateway.models.responses.PaymentTransactionCallbackErrorResponse
import java.io.Serializable
import java.time.OffsetDateTime

data class PaymentTransactionCallbackRequest(
    val operation: String,
    val pspOperationId: String? = null,
    val pspIdentifier: String? = null,
    val status: OperationStatus,
    val pspReferenceId: String? = null,
    var error: PaymentTransactionCallbackErrorResponse? = null,
    val paymentDate: OffsetDateTime? = null,
) : Serializable
