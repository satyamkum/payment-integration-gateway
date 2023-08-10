package com.deliveryhero.paymentgateway.models

import java.io.Serializable

data class ErrorResponse(
    val errorMessage: String? = null,
    val errorCode: Int = 0,
    val errorCodeName: String? = null
) : Serializable
