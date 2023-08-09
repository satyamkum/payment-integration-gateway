package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType

data class ExternalWallet(
    val identifier: String? = null,
    override val displayValue: String,
) : PaymentInstrument(PaymentInstrumentType.EXTERNAL_WALLET, displayValue)
