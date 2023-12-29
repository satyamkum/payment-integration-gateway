package com.deliveryhero.paymentgateway.models.responses

import com.deliveryhero.paymentgateway.models.enums.OperationStatus
import java.io.Serializable

abstract class BaseResponse(
    open val status: OperationStatus
): Serializable
