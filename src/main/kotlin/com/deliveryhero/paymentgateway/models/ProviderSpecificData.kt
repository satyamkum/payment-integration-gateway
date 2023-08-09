package com.deliveryhero.paymentgateway.models

data class ProviderSpecificData(
    var map: MutableMap<String, String> = mutableMapOf()
)
