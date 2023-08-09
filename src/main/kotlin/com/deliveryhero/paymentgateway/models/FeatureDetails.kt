package com.deliveryhero.paymentgateway.models

import com.deliveryhero.paymentgateway.models.enums.TransactionInitiatorType
import java.io.Serializable

data class FeatureDetails(
    val featureName: String,
    val transactionInitiatorType: TransactionInitiatorType = TransactionInitiatorType.CIT,
    val recurringPaymentContractId: String? = null,
) : Serializable
