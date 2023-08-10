package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.Money
import com.deliveryhero.paymentgateway.models.SecuredString
import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType


data class GiftCard(
    override val displayValue: String,
    val token: SecuredString? = null,
    val balance: Money? = null
): PaymentInstrumentData(PaymentInstrumentType.GIFT_CARD.name, displayValue)
