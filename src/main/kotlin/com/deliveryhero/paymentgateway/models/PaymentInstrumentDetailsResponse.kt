package com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response

import com.deliveryhero.paymentgateway.models.BaseResponse


/**
 * Response object for payment instrument details
 */
data class PaymentInstrumentDetailsResponse(
	override val data: PaymentInstrumentDetailsResponseData? = null,
) : BaseResponse(data)
