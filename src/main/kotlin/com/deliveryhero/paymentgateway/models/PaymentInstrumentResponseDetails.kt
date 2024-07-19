package com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response

import java.io.Serializable

/**
 * Response object for payment instrument card specific details
 */
data class PaymentInstrumentResponseDetails(
	val owner: String? = null,
	val bin: String? = null,
	val last4: String? = null,
	val issuerCountry: String? = null,
	val type: String? = null,
	val alias: String? = null,
	val expireAt: String? = null,
	val scheme: String? = null,
	val paymentProvider: String? = null,
	val channelName: String? = null,
) : Serializable
