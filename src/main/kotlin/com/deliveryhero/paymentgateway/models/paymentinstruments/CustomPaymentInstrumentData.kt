package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.fasterxml.jackson.databind.JsonNode

data class CustomPaymentInstrumentData(
    val data: JsonNode,
    override val type: String,
    override val displayValue: String,
) : PaymentInstrumentData(type, displayValue)