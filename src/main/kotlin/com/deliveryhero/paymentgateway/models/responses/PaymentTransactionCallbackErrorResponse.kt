package com.deliveryhero.paymentgateway.models.responses

import java.io.Serializable

data class PaymentTransactionCallbackErrorResponse(
    val message: String? = null,
    val code: String? = null
) : Serializable

