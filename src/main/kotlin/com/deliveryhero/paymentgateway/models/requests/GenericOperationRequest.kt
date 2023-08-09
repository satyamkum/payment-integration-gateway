package com.deliveryhero.paymentgateway.models.requests

import com.fasterxml.jackson.databind.JsonNode

data class GenericOperationRequest(
    val request: JsonNode,
    override val type: String,
    override val paymentTransactionId: String,
) : OperationPayload(type, paymentTransactionId)
