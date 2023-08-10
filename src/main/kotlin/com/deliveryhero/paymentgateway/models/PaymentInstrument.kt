package com.deliveryhero.paymentgateway.models

import com.deliveryhero.paymentgateway.models.paymentinstruments.PaymentInstrumentData
import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable

data class PaymentInstrument(

    @field:Schema(
        required = false,
        description = "Must be sent for existing tokens..Id to be used to fetch the payment instrument token details."
    )
    val paymentInstrumentId: String? = null,
    val paymentInstrumentData: PaymentInstrumentData,
    val shouldStorePaymentInstrument: Boolean = false,
    val paymentOption: PaymentOption? = null, //
    val paymentToken: String? = null, // Capture

    @field:Schema(
        required = false,
        description = "Indicates if the payment instrument in context is used within last two weeks"
    )
    val hadTransactionBefore14DaysAgo: Boolean? = null
) : Serializable
