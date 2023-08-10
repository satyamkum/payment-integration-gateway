package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.SecuredString
import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType

data class RawCard(
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
    val number: SecuredString,
    val securityCode: SecuredString? = null
) : Card(
    scheme, operationType, brand, issuer, bin, lastDigits, expiryMonth, expiryYear, holderName,
    PaymentInstrumentType.RAW_CARD.name, displayValue
)
