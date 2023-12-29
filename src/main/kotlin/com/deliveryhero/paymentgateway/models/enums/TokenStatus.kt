package com.deliveryhero.paymentgateway.models.enums

/**
 * Possible status values for the payment instrument token
 */
enum class TokenStatus {
	TEMPORARY,
	TOKENIZATION_REQUIRED,
	TOKENIZATION_FAILED,
	TOKENIZED,
}
