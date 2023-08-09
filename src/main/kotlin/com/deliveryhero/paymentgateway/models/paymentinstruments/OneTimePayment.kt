package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.SecuredString
import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType

data class OneTimePayment @JvmOverloads constructor(
	val token: SecuredString,
	override val displayValue: String = "OTP",
	val scheme: String? = null,
) : PaymentInstrument(PaymentInstrumentType.ONE_TIME_PAYMENT, displayValue)
