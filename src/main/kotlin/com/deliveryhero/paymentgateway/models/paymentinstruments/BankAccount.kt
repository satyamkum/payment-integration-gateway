package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.enums.PaymentInstrumentType

data class BankAccount @JvmOverloads constructor(
    val bic: String?,
    val iban: String,
    val accountHolderFullName: String,
    val branchCode: String? = null,
    override val displayValue: String,
    val clearingCode: String? = null
) : PaymentInstrument(PaymentInstrumentType.BANK_ACCOUNT, displayValue)
