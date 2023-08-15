package com.deliveryhero.paymentgateway.models.requests


data class CancelRequest(
    override val paymentTransactionId: String
) : BaseRequest(paymentTransactionId)
