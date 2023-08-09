package com.deliveryhero.paymentgateway.models.requests

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable


data class OperationRequest(

    @field:Schema(
        description = "The parameter type is used to determine the intended operation. The possible " +
                "pre-defined values are AUTHORIZE, CAPTURE, REFUND, CANCEL and TOKENIZE. Any other type can be sent, with related " +
                "payload, as far as the connector supports the operation.",
        required = true,
        example = "AUTHORIZE"
    )
    val type: String,

    @field:Schema(
        description = "Data required for executing an operation.. can be any of the defined child objects",
        required = true,
    )
    val payload: OperationPayload
) : Serializable
