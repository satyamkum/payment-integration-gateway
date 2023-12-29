package com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response

import com.deliveryhero.paymentgateway.models.enums.TokenStatus
import java.io.Serializable
import java.time.Instant

/**
 * Response object for payment instrument token specific details
 */
data class PaymentInstrumentResponseTokenDetails(
	val id: String,
	val token: String,
	val expireAt: Instant?,
	val status: TokenStatus,
	val paymentProvider: String,
) : Serializable
