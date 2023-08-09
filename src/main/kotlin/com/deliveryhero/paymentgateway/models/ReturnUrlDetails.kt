package com.deliveryhero.paymentgateway.models

import java.io.Serializable

data class ReturnUrlDetails(
    var successReturnUrl: String,
    var failureReturnUrl: String? = null,
    var cancelReturnUrl: String? = null
) : Serializable
