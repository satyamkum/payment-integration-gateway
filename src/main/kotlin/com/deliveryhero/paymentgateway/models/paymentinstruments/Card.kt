package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.SecuredString

abstract class Card(
    open val scheme: String?,
    open val operationType: String?,
    open val brand: String?,
    open val issuer: String?,
    open val bin: String?,
    open val lastDigits: String?,
    open val expiryMonth: String?,
    open val expiryYear: String?,
    open val holderName: SecuredString?,
    type: String,
    displayValue: String
) : PaymentInstrumentData(type, displayValue)
