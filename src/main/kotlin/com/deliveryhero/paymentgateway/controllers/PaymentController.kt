package com.deliveryhero.paymentgateway.controllers

import com.deliveryhero.paymentgateway.controllers.PaymentController.Companion.API_VERSION
import com.deliveryhero.paymentgateway.controllers.PaymentController.Companion.BASE_PATH_PAYMENTS
import com.deliveryhero.paymentgateway.models.enums.OperationType
import com.deliveryhero.paymentgateway.models.requests.OperationRequest
import com.deliveryhero.paymentgateway.models.responses.OperationResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.parameters.RequestBody as ReqBody
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(BASE_PATH_PAYMENTS + API_VERSION)
class PaymentController {

    @PostMapping(
        ENDPOINT_PAYMENT_EXECUTE,
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(
        tags = ["Payment APIs"],
        operationId = "executePspOperation",
        summary = "API for interacting with Third-party payment service providers",
        description = "This is an API for serving all kind of needs for PSP interaction. The same API can be used for" +
                " Authorization, refunds, captures, cancels and many more operations. The payload is defined for some" +
                " standard operations like Authorize, Refund, Capture, Cancel and Tokenize, but any other type of " +
                "custom operation can be performed through this API, by just passing the type and related payload.",
        requestBody = ReqBody(
            description = "Request body contains the Type of operation and required payload. The parameter type is used " +
                    "to determine the intended operation. The possible pre-defined values are AUTHORIZE, CAPTURE, REFUND, " +
                    "CANCEL and TOKENIZE. Any other type can be sent, with related payload, as far as the connector " +
                    "supports the operation. The parameter payload contains different type of objects depending upon " +
                    "the type.",
            required = true
        ),
        responses = [ApiResponse(
            responseCode = "200",
            description = "The response always comes with a HTTP 200OK. Its the status in the response body, which " +
                    "tells us about the actual result of the operation. The status can be Success, Pending or Error. " +
                    "Id in the response body can be null in case of status - Failure.",
            content = [Content(schema = Schema(implementation = OperationResponse::class))]
        )]
    )
    fun executePspOperation(
        @RequestBody operationRequest: OperationRequest,
        @RequestHeader headers: Map<String, String> // TODO - add subsidiary as mandatory header param
    ): ResponseEntity<OperationResponse> {
        // TODO
        return ResponseEntity.ok(OperationResponse(type = OperationType.CAPTURE.name))
    }

    companion object {
        internal const val ENDPOINT_PAYMENT_EXECUTE = "/execute"
        internal const val BASE_PATH_PAYMENTS = "/paymentGateway"
        internal const val API_VERSION = "/v1"
    }
}