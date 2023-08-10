package com.deliveryhero.paymentgateway.controllers

import com.deliveryhero.paymentgateway.controllers.PaymentProcessingController.Companion.API_VERSION
import com.deliveryhero.paymentgateway.controllers.PaymentProcessingController.Companion.BASE_PATH_PAYMENT_PROCESSING
import com.deliveryhero.paymentgateway.models.enums.OperationStatus
import com.deliveryhero.paymentgateway.models.enums.OperationType
import com.deliveryhero.paymentgateway.models.requests.UpdatePaymentRequest
import com.deliveryhero.paymentgateway.models.responses.UpdatePaymentResponse
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(BASE_PATH_PAYMENT_PROCESSING + API_VERSION)
class PaymentProcessingController {


    @PostMapping(
        ENDPOINT_PAYMENT_UPDATE,
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updatePayment(
        @RequestBody updatePaymentRequest: UpdatePaymentRequest,
        @RequestHeader headers: Map<String, String>
    ): ResponseEntity<UpdatePaymentResponse> {
        return ResponseEntity.ok(
            UpdatePaymentResponse(
                status = OperationStatus.SUCCESS, type = OperationType
                    .AUTHORIZE.name
            )
        )
    }

    companion object {
        internal const val ENDPOINT_PAYMENT_UPDATE = "/update"
        internal const val BASE_PATH_PAYMENT_PROCESSING = "/payments"
        internal const val API_VERSION = "/v1"
    }
}