package com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response

import com.deliveryhero.paymentgateway.models.enums.TokenCallbackStatus
import java.io.Serializable

/**
 * Response object for payment transaction for successful acknowledgement
 */
data class PaymentInstrumentTokenCallbackResponseData(
	val result: TokenCallbackStatus,
) : Serializable
