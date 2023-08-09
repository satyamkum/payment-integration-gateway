package com.deliveryhero.paymentgateway.models

import com.deliveryhero.paymentgateway.models.paymentinstruments.PaymentInstrument
import java.io.Serializable

data class PaymentInstrumentDetails(
    val paymentInstrumentId: String? = null,
    val paymentInstrument: PaymentInstrument? = null,
    val shouldStorePaymentInstrument: Boolean = false,
    val paymentOption: PaymentOption? = null,
    val paymentToken: String? = null,
    val hadTransactionBefore14DaysAgo: Boolean? = null
) : Serializable
