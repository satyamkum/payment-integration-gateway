package com.deliveryhero.paymentgateway.models

import java.io.Serializable
import java.math.BigDecimal

data class Money(
    val currency: Currency,
    val value: BigDecimal = BigDecimal.ZERO
) : Serializable
