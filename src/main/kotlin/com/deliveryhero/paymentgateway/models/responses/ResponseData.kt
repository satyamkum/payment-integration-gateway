package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.enums.OperationStatus

data class ResponseData(
    val pspOperationId: String? = null,
    val status: OperationStatus = OperationStatus.CREATED
)
