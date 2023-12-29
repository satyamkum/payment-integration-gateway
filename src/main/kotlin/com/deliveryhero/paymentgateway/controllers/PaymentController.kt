package com.deliveryhero.paymentgateway.controllers

import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentDetailsResponse
import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentDetailsResponseData
import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentResponseDetails
import com.deliveryhero.fintech.payment.gateway.client.paymentinstrument.dto.response.PaymentInstrumentResponseTokenDetails
import com.deliveryhero.paymentgateway.controllers.PaymentController.Companion.API_VERSION
import com.deliveryhero.paymentgateway.models.enums.OperationStatus
import com.deliveryhero.paymentgateway.models.enums.OperationType
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
import java.time.Instant
import java.util.*
import lombok.extern.slf4j.Slf4j
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import io.swagger.v3.oas.annotations.parameters.RequestBody as ReqBody

@RestController
@Slf4j
class PaymentController {


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
                            type = "Encrypted",
                            alias = "sdsd",
                            expireAt = "03/2030",
                            scheme = "Visa",
                        ),
                        tokens = listOf(
                            PaymentInstrumentResponseTokenDetails(
                                id = UUID.randomUUID().toString(),
                                token = "eyJlbmNyeXB0ZWRDYXJkTnVtYmVyIjoiYWR5ZW5qc18wXzFfMjUkWkFEQjB1M0xMQUduZnpwMGNqejlpR1Z2ZC8zUzE4dUVLQzZYUEx3M3dBa1hYcDZFTEovbmZITXRrblJqaTRubi9qNFFKdTZVNDJtcWxrTDRoVzVBTmk0YW1KdmM0ZW1UVGpTRlg2OUVXb3ZuZ0VVRVJlcFl5OXpwNHpRMk5lQ1pCTENzNi90b25iMjIwRzZEd0s3U0VMZ2liQUlpTFFDNmR0TUUzK0JYRFdXb3J0YkVsTWJLWDQ1cXkzZkxERDE2Ulk2dHNRT3hwSVJMdmQ0ZkdUZE1kV2hHSCtrajNpdUI1S0VjR3FBTlFzUkdPK1NpYWxvQlpXRDlWU3duQkNlMWZ5dkxtdmlra3g1S08zNk5sbEJvQSt6a0c1TG5KdmMrY0VieTBoQlpOMUliaVpBNjVOampvOU1vbVlXRDdEY3FRZEx4cThWQ25NczFNZEp2YzliVVRnPT0kVDNwYVBJMkM3SFlZbW5MUXhvMWNxSFhiTENveGhvamRJaGZDdE9wMmhaZEI5aHlycVhVTjQzMjZScFVjZ0FTQWpoMmFjWWpDdVorMUx5dmtFbmFYY3lVUnUyY2ZlcGtCNFVJSG1JQ3FvSk9wQTREM2VuaVRpYWM3cElwZWN2VG0vU2hUaElpTnBxQ25XVWJsMkUvcFRqM3AyeUxDK0w5bzMzYk1aS1hDSlNKd2hGSGpHbk9QN1IvRkpJUXFTdDZsbGYvRXRad2ovR0k5d3ZaSkVJVGdSdVpCNGM3NDhkM0VHMWZ2VURBeDFLUnVMOTI0bUVCUklFZy80bWU2bG5UalNMOEZtVmN6SnVFcytXUkRXNUhGS2tYbi9ZNkluNllVeHFRREs2SWdCOVd4RldpNmtXNVBSd0FWVUV3NEJCbDBWaWRqKzJxaE81MHBHcmR3WC9hSUpML3dXdnFiNUJDNEJXaG5MOFVEZncwOVhVVjlQMEJzWktoM1I4dW51ZCtyTGtPakNETDZSbFo1YW00Q3lzZnJsSjBTR3dSL0cxVXBpYmZSdGxnM0wwQlNodU9XL1IzMERQaSswR1Q1YWVQR05sdVpFa2ZobFJlME5VS2tHYzR4YXBVS29CZ3BOLzErWmFoS0xwTm1rMThaNEh1SUlvcUpoMWRFaW50c21ySWh3REN6azZWUTk2VndOSURzT25MWUViZVRkeG15b3VXTzU2WTQ0L3l2dnp3U1lmK2ZIUmF5T2gxSlNrUngwTysraHV2QWtPMVNhOGliVjQ3S0JFQjZMMmZyYUVpeGlVUzJZS3NxT0krSEJjeTl3RXg2R0ZDOVpFZjFzM0tTR0o3S2h1WDZRT01NbkhlRHJlcXhYUVJ5T3FHRnZuSnE5YmlYZWduUFVKbjdwUzFVdjdaMlIvY1lwYmtqb0t5N0kzSklpTlNCdllMUlVBdmhLMytzZ1BhWTNqdE93VFc2TGVFRFV2MHZTaWhvdlVjcDR3PT0iLCJlbmNyeXB0ZWRFeHBpcnlNb250aCI6ImFkeWVuanNfMF8xXzI1JGppSVlPeGhIcVJGWktuTldaVzdrTFgyVmx0WFlTRFVNaWw3ZVVWWGRQTC9KTE16bjNjajVTT0ZVU21xV1BOK3RYWUlTVW1YSnhIaE5WK2k3ODdRNEU2NGEvMzVWVEpSc2JxN3lObEhYTlZZWU5OdXdpSHpyZWJqVDBLa2hzalN3UWNYby91dldJUHFBYlB6N0x2VjBFNEJzejVOc2h6R1FQRElTcGkyVTBrYnVTR0RhUGpiUUEwZHJqM245S1ZkU3QxMU82ZVRYVmlMZ1BNRTF5MlkwRzE4aEg0RTNuLytNRXBuZ0ZLMzVidXVQNi81K2Y1eVlUbXNUclYzMTVWbFRrWEVteDRlUHh3R2owSUNuR3NIdVF0VDZxS0dZS3l0anhheFdDWHc1Z2JYcVFFNnhiNWFKcHloeFpwZ1BYaDd3eUVQc3ArOFlwM1hpL01rUGZvcndQZz09JDhCME1FejdMZnUzRjJwb3pmaDBpVWpsbE93dXZSd3ViSXQyTU0weGRMOXFRdXlZYnZHRVo3QTloS2xoeFQ0T3ZxTTNpOG1zY0ZRb295QmdERGNLczQ2ei9Temd3NGRVRFNTakJiL1AxU2pXcEJNOExGWXY4eVVyRk5KbTMvYksvcFdLT2hpaVZUMi9ORUxkZjNnajlwMnFmOG5KbzBoWko4am9Ec1RtTlUrZCtISnhBWDQ4bzYybG5NalFtNWtWZEtManBYUGYwNXFTOW1LbzRBM3R3UWU0bTh1M2gzb0lGcDkxamp4Z1J2WFYrWGwwblNKeThiQjdEREJuMnp6WEF1M1N5bkJuOUlWUVQwdkp5ZTBCdnpkZC9XSi9lNGFFbnVqaFFLYjdsVzROWWZObTlTY21xZGRnZmcwbll2bC9sUkJqWmExRnpVSVNEMyt5QVpmdmYrS2hzVVVOK29JbVZaQVVFNU1hMStOak5BMzgyeUREOXphb01CMjZ4enhJbFR5dm9MVm9Kak5rS2NQWUU4a1J3anNFMWJXaFlmSGxnZGhZZDA0UGpoMDk2WnZlV0V5WEJEOEtiUlQ5ZVJ4Q2NyMktCMDNCTXFQVUtHQ3oxQ0FNaldtY0pQUyt0SHMyaWRydXEzZHpvSXFCMW5Faz0iLCJlbmNyeXB0ZWRFeHBpcnlZZWFyIjoiYWR5ZW5qc18wXzFfMjUkcmJPVm9jUHB3S0NoV25xNUxpZERHcEFDN0xUU2Nld203MlFZQWMrT09MQnM1MG5jNGtsUnNsT2wxVXQwaERoZFc5cmlOUmlieUVJSjExMHlvZkFIbjNFaS9KbUw0UlRpQ0J0VFBhY3BxRzN4S1BkQzBUOFhDKzEvRFgzSmRpMTNVV25GY29zSURwVjc4S2x5ZEZpSFJEdWR1MHExWWkrdG9VZThxWXFtanhxd21HNW5TM1FzUS9vOXMxVFhNSXYycFVsMWpsQi9KQVNQZGd2d0xrWXRXTEVSZVoyNFFkNFg1Q1VpcjQ3M09iaTdRWTlrZXRPQUFIR3E5RzM0Y0t2QVFOblFVNGI3MXllTGczbkdwSENLRC9hNjhXdUljOWwvNVhISVRJZnUrYS9vR0hXc3ZWVEtsbkNuUjFsRnIzWks5bGJZanpydmdwR3QwcVhaZ0I2SElRPT0kODdOd0ttUmdoVFZYam8wdWRRRWNBR0w2Qno4QUpGQXRnNHRyeFIxeWJueGVTcFRWYlh5MHBnRkVDeVJJWVh0MWxmMm93REpseVo4QjdJK3ZURTJWUVNRN0hKc2RxWHB6cjg2dHdoanE3TzlIVTUvNnVMdjFvZ0x3MC9Mb0FnMUpmZFpWZm82THByNTllZzRqR0szODRtcjNPeE1sOHkxcDdUU0VFaTkvb1ZrbUNkeTVVbUM4UHhSQmlmRnlURVZ5WnpHOTkvYmd2OHVVTVhnTmRHeWdyMjRLbUhFWHFrRW44SzZCcVdDVi9hYWkybnVZY3pJTG5SbVMxMFpnNFYyRFFITEE4Mzd4VVkyOGxjOEcrZkFYQWFjSHY1TUhxMXY0UDFtNDgrZ2JmemR5RHRZWVd1eDgwaGl4aTdGeTIwbnh0eHNMVTJzVjhxaEZTZWdjcTBDSTlORFhYaHE4VFFuaklOUW15TzNyK0xvUlRrOG4vOWJ0d0lCVnMyQk5CWEJhV1Ivc2F4WGZBM3VCZ3oyQTJMNmc3N3RHYlhsWXZNMWVxTnJVUFVCZFJUd1kxdTdSL0UzdTFtVHlMdXVvZUI4NzJZbzdJK200Ujk4ZEdUTXRWNk15K2l2cE50aEUwSEpiQkcybWtYcklQZUdjUEJyVCIsImVuY3J5cHRlZFNlY3VyaXR5Q29kZSI6ImFkeWVuanNfMF8xXzI1JExqQ0lVRFJYRnFVTk9wbDN0MDZXK3dwdVh1OUVUNnpHS2Jtdlh3bUNTdWVUQStIdmdSL3lNUkpVcGluUkd5WjdqOHo0N0xQS0t0bXIrNFFxL2V4Uk50UitBOGxWMVVTb3NQNFNYdW9mVmxqR2dVa3hJOUdSQVZCUWFldzVRU1YrTmdkUTd6MjYvWVZ1ZWxiN2phVldWbXlXWGY1cktqeng2QkZPYnFrTElvMmFOeHZJS2diOWZlVUI3cnEwNlZQcjNEMjFBenZVZDNSeUtNa2dSaXN6L0FsSnQ2Nk4rdG0zNUZBYVB0S3NxN0tKVjNFS1VacjloU0s5S1dvald6YUw4cUV6cVRHRGt3M0crSnBWc0RkUld3MlhBR2U5RXk3OVJVMS9NK200NVpJR2RYNkpFSUowM3JGaFFnSDRNcEFFYWpEcldadHlaQXdROHhiM0VHZ296dz09JGF5aEwxNGs3K1c0NnpvdlFncTQzR1NhR0NjYkl5SkZJUCtTclVGV1l1SjVKRnRtVjl0cHl3eVR5UDNmNE9GL0FwT0hwK3Rxb3Nzc3RiM1hnM2tjSVNLUi85TTJSOGdNcEVSdmtmeFpSUy9xK3JBd3RkbkRibXhHeDFIN00xVS85K0dpdjVJOE9NSGwxSWdnK3dqOE5BUGdQWjFEcGlzQm9xaXRWemgvT3Q4cWg2bFJqd3dLVTAvRFlRdFJ0c0Y1Q1UrVnVObHVFOU9aOElYTElRU3Z4eUJsQUh2N3hHRzZNdVBkeWZ2S2NTS0NjQjZ4QWNkTFZDakVXRTNiUzlOdWhWMTFNTEhwM25xVDZkM1ZRK0hqQkN6c2pLWi9PbitkbGptaDQwaFd3djlVdFl3RDhyaUg0dzJRV3lpUEcraEYrK3h6ME1JWEd2THZjTkZxNFkweWdranl5WkpJMiszVi9ySTMrZ3VFd2dveFo1RkVJbngwK0lxSWlmWnY4djNEV05EWVZreXAreHdUcUVjTUlmQmd0bVlpYTkvMnR1T3loZ1JPS0JPZGlSaHlJL0lYZnNsM1AyS0dzdzBvSkNnYndndDltRkZRa2wyTGdYWmlDcFFpcS9LcGlITVpOQUdOQzhWTFJmUjFTVW02Tm1seUpDUVNZK1U3aWVIZGZWNWQ2VXBHdWNnV1RtN2pBcEFrUTlCN0hISlBOcjJLTzVQMTdJT0ZKL2thOFB1SWVqczM3V2pYTjJiYWs5SDdJTmtHSjlzNnhzemR4T0svcnY1N0lOTEJGd09JN3Y5NnhOaDBsdXJMamRPaGFWcmtNdzBkNFV5cz0iLCJob2xkZXJOYW1lIjoiVGVzdCJ9",
                                expireAt = Instant.parse("2024-10-16T10:14:56.125897Z"),
                                status = TokenStatus.TEMPORARY,
                                paymentProvider = "adyen",
                            )
                        )
                    )
                )
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
