package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.enums.OperationStatus

data class OperationResponse(
    val id: String? = null,
    override val type: String,
    override val status: OperationStatus = OperationStatus.PENDING
) : BaseResponse(type, status)