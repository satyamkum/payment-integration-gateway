package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType
import com.fasterxml.jackson.annotation.JsonProperty

data class Wallet(
    @JsonProperty("id") val id: String,
    @JsonProperty("displayValue") override val displayValue: String,
    @JsonProperty("accounts") val accounts: List<WalletAccount>? = null
) : PaymentInstrument(PaymentInstrumentType.WALLET, displayValue)