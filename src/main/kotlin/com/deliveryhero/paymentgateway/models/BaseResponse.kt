package com.deliveryhero.paymentgateway.models

import java.io.Serializable

/**
 * Base structure of response, must be the superclass of every API response for the service
 */
abstract class BaseResponse(
	open val data: Any? = null,
	open val errors: List<Any>? = null,
) : Serializable
