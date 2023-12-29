package com.deliveryhero.paymentgateway.models

import java.io.Serializable

data class ErrorResponse(
    val message: String? = null,
    val code: Int = 0
) : Serializable
