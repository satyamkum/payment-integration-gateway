package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.ErrorResponse
import com.deliveryhero.paymentgateway.models.RawPspData
import com.deliveryhero.paymentgateway.models.enums.OperationStatus

data class PspOperationResponseData(
    val operationType: String,
    val gateway: String? = null,
    val status: OperationStatus,
    val rawPspData: RawPspData? = null,
    val pspReferenceId: String? = null,
    val error: ErrorResponse? = null
)
