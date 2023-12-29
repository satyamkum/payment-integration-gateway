package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.ErrorResponse

data class PaymentTransactionCallbackResponse(
    val data: PaymentTransactionCallbackResponseData,
    val errors: List<ErrorResponse>? = null
)
