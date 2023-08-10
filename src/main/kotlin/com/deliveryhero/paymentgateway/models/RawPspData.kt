package com.deliveryhero.paymentgateway.models

import java.io.Serializable

data class RawPspData(
    val rawPspCode: String? = null,
    val rawPspMessage: String? = null
) : Serializable
