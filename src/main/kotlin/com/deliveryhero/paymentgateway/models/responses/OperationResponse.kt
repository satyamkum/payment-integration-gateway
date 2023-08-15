package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.ErrorResponse

data class OperationResponse(
    val data: ResponseData,
    val errors: List<ErrorResponse>? = null
)