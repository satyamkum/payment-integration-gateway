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
                PaymentInstrumentDetailsResponse(
                    data = PaymentInstrumentDetailsResponseData(
                        id = paymentInstrumentId,
                        globalEntityId = "fo_no",
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
                                token = "eyJlbmNyeXB0ZWRDYXJkTnVtYmVyIjoiYWR5ZW5qc18wXzFfMjUkbnlRY0wxVE9qR3REVkpwLzk1Skd1VlpqYlorVHk0QkxWTnlZSUxLc3o0VkdUUmo1akZpOHFmN2JNM2diS242RkVzUkNBeEFWOTNDYUt2QkhMVDhrRStOUFVwRlpyWWpBdFZUWGVVSmR4enlWR2tOTlowVHU2ZUJLcHNla2xRMXNFbE40cWduWk5CWjQvYXRNTkowQzg1VU8wSVFIQmtDQUkzTVVFMGJjbkxudlREclNLSlRIclpPM3hXT1lHejA1SkRtdnN1RW9BYWtaSWlqckFYdWlmc3dwVElLZGdPWjd0amEvOG5tNE8vZUVMZkJzZURXSFdSS0ZtZkUxd3NHUi9YMXFMR0tNVnZGWHUvQ0VITmpXaXMvbW5mTXd0eVF5VzIyMzhqK3BCcGZQeXhidXNtSC95SXp4NlVoOEFiNUdvc2FDMDc5Mi9nSm9kV2kvYTVFZ2xnPT0kK0ZKMXFXdG8yTHYzSGc4S0FOYXA1VVVkV0Z6dUl6Ti9XVnIvblVXNGdKMnZocVNoMDk4TEpQeFNQMW1nU1ZjaWRFYnZrRDZUb0trbk4wcktHR1UxbkE4TFVZckJIZ3ZXWGlFMVhGZERNeGR3NGRWOXBid1J0OWMvVC9zT1dSOHVQM3p0aUdqa1FIeDV1UVEvdXdNbVFtcG1OWDhTa2VPbnpHcUlhNnNocmFLSnZKZWhpTlgrY0VHYzlueUxqN3FLbFJobytlYVZkdkVPNzBEWXE3RVF0RThIT0xZL25yanUxa0xpWG5Db1hjS3U0QkVMMlp0M21TMHdsMWtSd293R2NETWtYNHB6a0xyQXJudVE1UXgvMHhnUXpheGtIQjZseEUyckd2K3hDUStrOGpUY3Z3RU9jUDR6VDdZa0NncXIya3pDWTFVR3IwTGpKM1dBMXBYMW9VNFpTdlB0WXBFczJ4ZnVScjBQVGZaWURPZFN4bDVVM1dzUUJSUXpicGlxTU9iazg4T2J0bUprSVB5WTBVYUZHZ2ExOHpGR01ZMVVhWjRPdDNjR2ZWckEvbUtRbEVna2Y3UFlLNzdybWlkS2FoSkQySVFJQSt5dTZtVjRRZW1tNU9EYWY5L0plNVFrTVA4NDhjRDZwZHJUWFlsTGp3ZS9jWVFhQTkrSlN6MmN5MUhCRCtsQS9QMmRoSkF4ejcxWE1INmVxSVd1VVVoVktqb3pSUEhqOXZTd0V2M0VaanFDU2RPajJrYnZ5eXhRbkFsOHV5bHN3a2FLdVB0RmZTNVdsMkFPdnVQRFdpU3ZTcHNJMjlGZ2h4ck1tUFdiR1NqaUpEQnNtWTduQTVibkxlZzFuMVczMkZ6cVhhbE9JeWl4UGQ5SGgzY2pTcWhIWjB0MDZvWlhnOWJsK1d6WnpMU1RvT3VlYXV4dkw3NGlPMEt2TWcxdWhwUGxucUVZc3JqbDI0TWZTdVlWUWpUeUpXd08zYy8wak1hOEt4aEE5UjgzbjB4bkN5UFVXZ0ZobEFzMTM4dUhxN1VtWXliWlRLdHNPZFI1clNjPSIsImVuY3J5cHRlZEV4cGlyeU1vbnRoIjoiYWR5ZW5qc18wXzFfMjUkd1RWNDZFdHk0RDRJZjUzK0tadlo1T3BtenhZalBSYWdoMWZkV3kzc2RySlVvR2h5YUhrUXk3TVY1ZGExWHp6ekZHc2J6cGk1KzIxY1pVcnI2SkhLZ2pkUnZUYVU1TXRHbHRLV3pMWGhVVUd2bFpRK2JMaU94dS9VZ0RPZzM1M0JKcUJzSm9RdUdpL0lTcnVhR2tOUnFxVTlmeFVEKy9HZ0V5aVl2Y2NlQTZMQVdJZ0V3SFdYNGVTS21yazJxanlkamI0YU1QSmtHRnJTL3gyU3VjbE5ETkdpSEFYeFVBbk04cStGd2J2dlA2bTRDSHY2TDhvdElKU3FVbHUxODRFcUhkZEphL2pSQWkvdVJHd2MzUmpVVFV6TkE3SFZzV2lqZlIzeUpuaTNUY1JZSW80Rnk4dXBuZFphQ1VpWXlsV2YvZVprdTdocWhaWkVzeFZrQ21tK1NBPT0kdnpFcnlCbU1BblFmcHVqTmUvMHlFVDV5eTg1NEVVTTZBbnVaZ1FZYmFOdW9SY0ZtSldWOU1KUzFNNkkwcDFLWUJpWEZzL3puamZLMjRGZUdPbm8vTGlycnNLQ1R6cGlOQ2JuRVFQRjAwQUYyZHdhbUExcnRQdTRZRzhtN3FZMXVib2ZUWCtMWmlzRTZUbVZicjJscnhTUjBDclF0eVpKc2I1cHZZYjR4RnBob09zS3ZpRHNPdGoxRDBnM0R0NC93a3Q2QzBJdW9tWHdoWG5BTmhnYmxQTU1qTmtWNXFwK1YvaFhMM0ttKzFQR1FLcndrbGdERmpHUXp1U3dKNzQzYmZBT2EyY1h4bWFXV2JZSnNrYk0xNVpEdWFTaUhQUDk2OXpWTE4ybzNXeEpLakNSLzVTa1BFM0VqNXpTTTZ2Q3N2cmlJTkFxd0dlbWhCNXVBOTkya1VYcXFPVDkrWTFTZ2d6aWN4TjlPN0VKcjV6eldJVUNEdjBRcEJtMURkZGNPaThXMnJwUS8vYzVOb2FXWWNLS1d3YUV1bmt1UXJkQUhhLzJhTEQ3SDdNaFlpY1pSZTZUWk4zQW1NZzVpTjM3OU5qS3BFeDlrdFI2eTcveEdyV2FhbnJwc29RKzQyQThhUEY0R2o1bUVJUWRGZDViZEdkNExMUT09IiwiZW5jcnlwdGVkRXhwaXJ5WWVhciI6ImFkeWVuanNfMF8xXzI1JHJlQUpWMTZjUjlCK3dObkdWbGJDRFgyYWlRRTBJNmoxUGwxNE8zckEvNElvbTViV0NLOXBvVHhkV3g5UXpoajFXbUtkRWZiT1Z5UkhZSmFVQWx6WExieGtvcFUxOWVWQlpzN2VweUpzVTN6ZHZCT2xmWTBmWC9nMUNkNHlVcU5VMm1ncWNWbnZYOGovZGx4QmJrZDhnNkpjczBuQTBQS1l1QXhLQ1RIc2FxRk5NVURGaG1ZRncxK2x6RUd6NnR3RHlFOHN3cDNwalRyZEhQVmZhc0UxL2pFKzBud1FHSGs1L0c2RHJURHlWWnRPNFFDMTV0Z1h5RUFIb2t4NXBydTZDUHUwa1VLc2liT0t6ZGd3b1ViTU5lbURrZFBhREVxKzFRVTNzWjk0VHFxM0lhVG5FeVJEOVdNeWVaeE1LY2p2cjU2Vlg4ZERWMFE4MGpqUDVKWGppdz09JE5BdlYzQ29TMURhM1lOWG1CbWJMNllTNlBJTEtJNUx0Y2NMU0lFV0Q5MGZlQWhvOGw4TFU1TFlLZUl2RHFZS1NnVDdKT2RWSmh6ZXFaT0lzTGhmQnpTWmFCSTR5S0NqZStxNkUvelQwYmpTSlc2bWhURitVZ09ZZFBBd3B5OFBlQjE5M0dWMjNVVXFGZ2V3RVAxZTh0RU5LbGo3OVNTZTR6YjZFY255b2ZzWWxLejJWYTZQUUpGbm13bnFxOWh3TTU4eUd2Vnh0SHNCNE9vU25PNHIvdTFLbXA1ai82L2FWQ1F4Umh5SmxmS1hpRXk5NG1LbzRKL3o4NFlCNW43QngvcnZTWHVKN0F1WmJXbFU4M0EyalFHc2pmM2RYNkE2c2xWNHFGQkhkQy8zQnVyeG1STHQ5WCs3aEdpbUt6Z2RvcE03amFzU1VieG1qVkdaUWI1dTN6dnpaVlhsOEhhUndUZWZUYTQxdDNpVEJYUWNndTdxVWs0SzU1Ynp0RzM0ZnZvbVFpUG5EVThpa05Dd3gyQVVlZWRveUI4RlN0Tkp2UlVMTzdSYTJMU0RWenlGa3I4N2NjNEpraVhTNXloQmRPRm9qcEtvTGxDQXhSK0ZnMTRoeVYrTmduSHpDMXQ1R3hFbStUZnJLRUw1ekpybVgwM0ZyTkZrPSIsImVuY3J5cHRlZFNlY3VyaXR5Q29kZSI6ImFkeWVuanNfMF8xXzI1JGJFaVQwaUxzb3BwY1huZ2lGSENBTlJWWk1jdVgvazFBMzd5UE5RMnkxZGJpTUJuT0hkRHRHOTJYamxjMWtWQ3R2aUpkSDdieFY5TG1XbEt4ekNNL3Y0V1drSjFnNEVIblRrMmlYNXkxWjBxRUdyU3ZQQlg4alJHWG1NaGlmNkZKbzVVMkZPdlJZUnYvaEtCdGV2UnlsSk9FTVlMT1hxQVUzMS9lVFlweHhMaWFBOVN3aDBnVmVQR0pPOGcyNFM1WXB5ekhZY0VDd0pKaTdQclFqb0U0dTJJVTlrU1A0Y1hOZ3JSN3liQmNUYks0Y3NvNGdDemN0cWlNMGpFT2lacHg1aVc3S0g3SDJYQmFxMDBmZTJNWFlpck1RSGU5NytxZFlnZTE4N0gzd3UrUGxUTC84L2kxVnloM2VkdVk4L2ZMcEpuMTMrZTVZNEZhS29tTUcwUDBKdz09JDFSVnhKRWRCZFBYMVdCZ2hpK0lDWldIS2h6bTZPb05tVEIzeHVwaVVrT3ZwOHBsN0dGV2RJcUtBSGVFZzVUbFVzU25tR2phRmpPT2hqV0hUVkhNQytMRVlLelplS0NlazQ1WkZ4aGs4L3dSRGVaMWpKV3FFdjd4UTh4SkhFTXNaZDY5QVp4VHNhcDkyTTZ6Z3phRWREck9kYXUyRHBQeDlFU3NsTCtNVTF6b3ppa1VLMVUwM2g4bHc3R0hwVU1DckdxMDB2aVRvdlJDM1lJNHN6UHE5a3ZHbnpFOWptWlNjZ0F0emV5ZE5MR3phbTNKUmcreFZkL0Z5K0p2Z2NFdC9LOVVkcDRZVngwRTZVN0ZpdSs2RjVKL0EvbkliNWp4L2Q3L2k3VDBxM2JGaTZMUmNWU1pmN1hoTG96S1pNdUUzbFpHaE9ld0FtTzZXVUtTdkx5TWVKZ1cyY1AwVmU2UkZ5UmJRQ0FGeERGMmdWOEFxZnNPSmRRNjJxMmgrUml6akU2SUQrMnF2Q3NVeTRRTWlHaVU0Z2phbTh0Vm9QcVg4YnYzSUt1ckliRFNiT1Q2Ty9MUmlQMjYvczlINWlDejlHaEtyVGV1MkE5MUpDZ0E1Y292QlBHVUd2aVhJUE1KVWJBYXpjSE9UbFU5OEc1T25sOXE4K3ZhNHozSDBzTElpQlYzZjllU2wreGUyOWNhTm96UExVOGl0cS9nUEMrUml4ZWF6clNtVFVxOEVGRGUyVVpOdmxPblRDakYwV3NHSUZ2SWliczhtaTVSVHJEaFNHSFJHSVNJenc1R0ZIQT09IiwiaG9sZGVyTmFtZSI6IlRlc3QifQ==",
                                expireAt = Instant.parse("2024-10-16T10:14:56.125897Z"),
                                status = TokenStatus.TOKENIZATION_REQUIRED,
                                paymentProvider = "adyen",
                            ),
                        ),
                    ),
                ),
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
