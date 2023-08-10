package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.enums.OperationStatus

data class UpdatePaymentResponse(
    val correlationId: String? = null,
    override val status: OperationStatus,
    override val type: String
) : BaseResponse(type, status)
