package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.fasterxml.jackson.annotation.JsonProperty

data class WalletAccount(
    @JsonProperty("id") val id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("type") val type: String,
    @JsonProperty("balances") val balances: Balances
)