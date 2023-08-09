package com.deliveryhero.paymentgateway.models

data class PaymentOption @JvmOverloads constructor(
    val name: String? = null,
    val id: String? = null,
    val balance: Int? = null,
    val expiryDate: String? = null,
    val currencyCode: String? = null
)
