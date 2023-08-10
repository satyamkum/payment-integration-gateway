package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.SecuredString
import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType

data class EncryptedCard(
    override val scheme: String?,
    override val operationType: String? = null,
    override val brand: String? = null,
    override val issuer: String? = null,
    override val bin: String?,
    override val lastDigits: String?,
    override val expiryMonth: String?,
    override val expiryYear: String?,
    override val holderName: SecuredString?,
    override val displayValue: String = lastDigits ?: "<ENCRYPTED>",
    val encryptedData: String,
    val encryptedSecurityCode: String? = null
) : Card(
    scheme, operationType, brand, issuer, bin, lastDigits, expiryMonth, expiryYear, holderName,
    PaymentInstrumentType.ENCRYPTED_CARD.name, displayValue
)
