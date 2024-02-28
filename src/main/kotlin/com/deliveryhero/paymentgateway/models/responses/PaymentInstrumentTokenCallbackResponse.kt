package com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response

import com.deliveryhero.paymentgateway.models.BaseResponse

/**
 * Response object for payment instrument token callback
 */
data class PaymentInstrumentTokenCallbackResponse(
    override val data: PaymentInstrumentTokenCallbackResponseData? = null,
) : BaseResponse(data)
