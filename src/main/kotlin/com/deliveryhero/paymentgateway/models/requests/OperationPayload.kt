package com.deliveryhero.paymentgateway.models.requests

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true
)
@JsonSubTypes(
    Type(value = AuthorizationRequest::class, name = "AUTHORIZE"),
    Type(value = CaptureRequest::class, name = "CAPTURE"),
    Type(value = RefundRequest::class, name = "REFUND"),
    Type(value = CancelRequest::class, name = "CANCEL"),
    Type(value = TokenizeRequest::class, name = "TOKENIZE"),
    Type(value = GenericOperationRequest::class, name = "*"),
)
abstract class OperationPayload(
    override val type: String,
    override val paymentTransactionId: String
) : BaseRequest(type, paymentTransactionId)
