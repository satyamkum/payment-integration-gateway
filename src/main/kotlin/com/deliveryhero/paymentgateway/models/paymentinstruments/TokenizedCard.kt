package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.SecuredString
import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType

data class TokenizedCard @JvmOverloads constructor(
    override val scheme: String?,
    override val operationType: String? = null,
    override val brand: String? = null,
    override val issuer: String? = null,
    override val bin: String?,
    override val lastDigits: String,
    override val expiryMonth: String?,
    override val expiryYear: String?,
    override val holderName: SecuredString?,
    override val displayValue: String = lastDigits,
    val token: SecuredString,
    val encryptedSecurityCode: String? = null,
    val fingerprint: String? = null,
    val additionalData: Map<String, Any>? = null,
    val alias: String? = null,
    val updated: Boolean? = false,
    val instrumentIdentifierID: String? = null,
    val subscriptionId: String? = null,
    val instrumentStatus: String? = null
) : Card(
    scheme, operationType, brand, issuer, bin, lastDigits, expiryMonth, expiryYear, holderName,
    PaymentInstrumentType.TOKENIZED_CARD, displayValue
)
