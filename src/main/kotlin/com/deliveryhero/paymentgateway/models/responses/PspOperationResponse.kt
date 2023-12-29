package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.ErrorResponse

data class PspOperationResponse(
    val data: PspOperationResponseData,
    val errors: List<ErrorResponse>? = null
)
