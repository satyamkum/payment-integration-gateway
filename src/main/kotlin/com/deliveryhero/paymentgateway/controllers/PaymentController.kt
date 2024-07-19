package com.deliveryhero.paymentgateway.controllers

import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentDetailsResponse
import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentDetailsResponseData
import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentResponseDetails
import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentResponseTokenDetails
import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentTokenCallbackResponse
import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentTokenCallbackResponseData
import com.deliveryhero.paymentgateway.models.enums.OperationStatus
import com.deliveryhero.paymentgateway.models.enums.OperationType
import com.deliveryhero.paymentgateway.models.enums.TokenCallbackStatus
import com.deliveryhero.paymentgateway.models.enums.TokenStatus
import com.deliveryhero.paymentgateway.models.requests.AuthorizationRequest
import com.deliveryhero.paymentgateway.models.responses.OperationResponse
import com.deliveryhero.paymentgateway.models.responses.PspOperationResponse
import com.deliveryhero.paymentgateway.models.responses.PspOperationResponseData
import com.deliveryhero.paymentgateway.models.responses.ResponseData
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import lombok.extern.slf4j.Slf4j
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.*
import io.swagger.v3.oas.annotations.parameters.RequestBody as ReqBody

@RestController
@Slf4j
class PaymentController {

    @PutMapping(
        "/payment-instruments/{paymentInstrumentId}/tokens/{tokenId}",
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun updatePaymentInstrument(
        @PathVariable paymentInstrumentId: String,
        @PathVariable tokenId: String,
        @RequestBody payload: Any,
        @RequestHeader headers: Map<String, String>,
    ): ResponseEntity<PaymentInstrumentTokenCallbackResponse> {
        println("PUT call for id $paymentInstrumentId and tokenId: $tokenId, with payload: $payload")
        return ResponseEntity.ok()
            .body(
                PaymentInstrumentTokenCallbackResponse(
                    PaymentInstrumentTokenCallbackResponseData(TokenCallbackStatus.SUCCESS),
                ),
            )
    }

    @GetMapping(
        "/payment-instruments/{paymentInstrumentId}",
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun getPaymentInstrument(
        @PathVariable paymentInstrumentId: String,
        @RequestHeader headers: Map<String, String>,
    ): ResponseEntity<PaymentInstrumentDetailsResponse> {
        println("GET call for id $paymentInstrumentId")

        return ResponseEntity.ok()
            .body(
                if (paymentInstrumentId.startsWith("paytrail", true)) {
                    PaymentInstrumentDetailsResponse(
                        data = PaymentInstrumentDetailsResponseData(
                            id = paymentInstrumentId,
                            globalEntityId = "po_fi",
                            isPermanent = false,
                            paymentMethodName = "onlinebanking",
                            details = PaymentInstrumentResponseDetails(
                                owner = "Test User",
                                bin = "464646",
                                last4 = "4644",
                                issuerCountry = "FI",
                                type = "Tokenized",
                                alias = "sdsd",
                                expireAt = "03/2030",
                                scheme = "Visa",
                                channelName = "nordea",
                                paymentProvider = "paytrail",
                            ),
                        ),
                    )

                } else if (paymentInstrumentId.startsWith("kh", true)) {
                    PaymentInstrumentDetailsResponse(
                        data = PaymentInstrumentDetailsResponseData(
                            id = paymentInstrumentId,
                            globalEntityId = "np_hu",
                            isPermanent = false,
                            paymentMethodName = "szep",
                            details = PaymentInstrumentResponseDetails(
                                owner = "Test User",
                                bin = "464646",
                                last4 = "4644",
                                issuerCountry = "FI",
                                type = "Tokenized",
                                alias = "sdsd",
                                expireAt = "03/2030",
                                scheme = "Visa",
                                channelName = "kh",
                                paymentProvider = "bigfish",
                            ),
                        ),
                    )
                } else if (paymentInstrumentId.startsWith("otp", true)) {
                    PaymentInstrumentDetailsResponse(
                        data = PaymentInstrumentDetailsResponseData(
                            id = paymentInstrumentId,
                            globalEntityId = "np_hu",
                            isPermanent = false,
                            paymentMethodName = "szep",
                            details = PaymentInstrumentResponseDetails(
                                owner = "Test User",
                                bin = "464646",
                                last4 = "4644",
                                issuerCountry = "FI",
                                type = "Tokenized",
                                alias = "sdsd",
                                expireAt = "03/2030",
                                scheme = "Visa",
                                channelName = "otp",
                                paymentProvider = "bigfish",
                            ),
                        ),
                    )
                } else if (paymentInstrumentId.startsWith("mkb", true)) {
                    PaymentInstrumentDetailsResponse(
                        data = PaymentInstrumentDetailsResponseData(
                            id = paymentInstrumentId,
                            globalEntityId = "np_hu",
                            isPermanent = false,
                            paymentMethodName = "szep",
                            details = PaymentInstrumentResponseDetails(
                                owner = "Test User",
                                bin = "464646",
                                last4 = "4644",
                                issuerCountry = "FI",
                                type = "Tokenized",
                                alias = "sdsd",
                                expireAt = "03/2030",
                                scheme = "Visa",
                                channelName = "mkb",
                                paymentProvider = "bigfish",
                            ),
                        ),
                    )
                } else {
                    PaymentInstrumentDetailsResponse(
                        data = PaymentInstrumentDetailsResponseData(
                            id = paymentInstrumentId,
                            globalEntityId = "py_hn",
                            isPermanent = false,
                            paymentMethodName = "card",
                            details = PaymentInstrumentResponseDetails(
                                owner = "Test User",
                                bin = "464646",
                                last4 = "4644",
                                issuerCountry = "NO",
                                type = "Tokenized",
                                alias = "sdsd",
                                expireAt = "03/2030",
                                scheme = "Visa",
                            ),
                            tokens = listOf(
                                PaymentInstrumentResponseTokenDetails(
                                    id = UUID.randomUUID().toString(),
                                    token = "Z5QlbF9SL64JI4DfXs3Ug6XaxSl",
                                    expireAt = Instant.parse("2024-02-28T13:40:24.2071905Z"),
                                    status = TokenStatus.TOKENIZATION_REQUIRED,
                                    paymentProvider = "spreedly",
                                ),
                            )
                        )
                    )
                }
            )
    }

    @PostMapping(
        ENDPOINT_PAYMENT,
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
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
            required = true,
        ),
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "The response always comes with a HTTP 200OK. Its the status in the response body, which " +
                        "tells us about the actual result of the operation. The status can be Success, Pending or Error. " +
                        "Id in the response body can be null in case of status - Failure.",
                content = [Content(schema = Schema(implementation = OperationResponse::class))],
            ),
        ],
    )
    fun pay(
        @RequestBody authorizeRequest: AuthorizationRequest,
        @RequestHeader headers: Map<String, String>, // TODO - add subsidiary as mandatory header param
    ): ResponseEntity<OperationResponse> {
        // TODO
        return ResponseEntity.ok(OperationResponse(ResponseData()))
    }

    @Operation(
        tags = ["Payment APIs"],
    )
    @GetMapping(
        ENDPOINT_PAYMENTS_GET_OPERATION,
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun getOperationById(
        @PathVariable pspOperationId: String,
        @RequestHeader headers: Map<String, String>,
    ): ResponseEntity<PspOperationResponse> {
        // TODO
        return ResponseEntity.ok(
            PspOperationResponse(
                PspOperationResponseData(
                    operationType = OperationType
                        .AUTHORIZE.name,
                    status = OperationStatus.SUCCESS,
                ),
            ),
        )
    }

    companion object {
        internal const val ENDPOINT_PAYMENT = "/payments"
        internal const val ENDPOINT_PAYMENTS_GET_OPERATION = "/payments/{pspOperationId}"
        internal const val API_VERSION = "/v1"
    }
}
