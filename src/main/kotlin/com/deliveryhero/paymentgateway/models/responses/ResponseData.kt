package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.enums.OperationStatus

data class ResponseData(
    val correlationId: String? = null,
    val status: OperationStatus = OperationStatus.SUCCESS
)
