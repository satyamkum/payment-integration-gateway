package com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response

import java.io.Serializable

/**
 * Response object for payment instrument details
 */
data class PaymentInstrumentDetailsResponseData(
	val id: String,
	val externalId: String? = null,
	val globalEntityId: String,
	val paymentMethodName: String,
	val isPermanent: Boolean,
	val details: PaymentInstrumentResponseDetails,
	val tokens: List<PaymentInstrumentResponseTokenDetails> = listOf(),
) : Serializable
