package com.deliveryhero.paymentgateway.models.requests

import com.deliveryhero.paymentgateway.models.ErrorResponse
import com.deliveryhero.paymentgateway.models.RawPspData
import com.deliveryhero.paymentgateway.models.enums.OperationStatus


data class UpdatePaymentRequest(
    val correlationId: String? = null,
    val gateway: String? = null,
    val status: OperationStatus,
    val rawPspData: RawPspData? = null,
    val error: ErrorResponse? = null,
    override val paymentTransactionId: String
) : BaseRequest(paymentTransactionId)
