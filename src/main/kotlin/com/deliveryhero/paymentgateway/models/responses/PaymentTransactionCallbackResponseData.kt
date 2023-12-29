package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.enums.OperationStatus

data class PaymentTransactionCallbackResponseData(
    val status: OperationStatus = OperationStatus.SUCCESS
)
