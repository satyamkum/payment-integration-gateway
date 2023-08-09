package com.deliveryhero.paymentgateway.models.requests

import java.io.Serializable

abstract class BaseRequest(
    open val type: String,
    open val paymentTransactionId: String
) : Serializable
