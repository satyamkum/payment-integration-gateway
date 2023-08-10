package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType

data class ExternalWallet(
    val identifier: String? = null,
    override val displayValue: String,
) : PaymentInstrumentData(PaymentInstrumentType.EXTERNAL_WALLET.name, displayValue)
