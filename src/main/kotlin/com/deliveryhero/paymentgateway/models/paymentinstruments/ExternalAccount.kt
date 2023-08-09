package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.SecuredString
import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType
import java.util.Date

data class ExternalAccount @JvmOverloads constructor(
    val externalUserId: String? = null,
    val externalAccountId: String? = null,
    val paymentInstrumentToken: SecuredString? = null,
    override val displayValue: String,
    val paymentInstrumentTokenExpiryTime: Date? = null,
    val refreshToken: SecuredString? = null,
    val refreshTokenExpiryTime: Date? = null,
) : PaymentInstrument(PaymentInstrumentType.EXTERNAL_ACCOUNT, displayValue)
