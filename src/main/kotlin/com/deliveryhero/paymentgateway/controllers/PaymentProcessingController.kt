package com.deliveryhero.paymentgateway.controllers

import com.deliveryhero.paymentgateway.models.enums.OperationStatus
import com.deliveryhero.paymentgateway.models.responses.PaymentTransactionCallbackResponse
import com.deliveryhero.paymentgateway.models.responses.PaymentTransactionCallbackResponseData
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentProcessingController {

    @PostMapping(
        ENDPOINT_PAYMENT_TRANSACTION_CALLBACK,
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun updatePayment(
        @PathVariable transactionId: String,
        @RequestBody paymentTransactionCallbackPayload: Any,
        @RequestHeader headers: Map<String, String>,
    ): ResponseEntity<PaymentTransactionCallbackResponse> {
        println(
            "Mock payment processing receiver - Callback received for transactionId: $transactionId -$paymentTransactionCallbackPayload",
        )

        return ResponseEntity.ok().body(
            PaymentTransactionCallbackResponse(
                PaymentTransactionCallbackResponseData(
                    status = OperationStatus.SUCCESS,
                ),
            ),
        )



        /*return ResponseEntity.ok(
            PaymentTransactionCallbackResponse(
                PaymentTransactionCallbackResponseData(
                    status = OperationStatus.SUCCESS,
                ),
            ),
        )*/
    }

    @PostMapping(
        ENDPOINT_PAYMENT_SUB_REFUND_CALLBACK,
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun updateRefund(
        @PathVariable transactionId: String,
        @RequestBody paymentTransactionCallbackPayload: Any,
        @RequestHeader headers: Map<String, String>,
    ): ResponseEntity<PaymentTransactionCallbackResponse> {
        println(
            "Mock payment processing receiver - Callback received for transactionId: $transactionId -$paymentTransactionCallbackPayload",
        )

        return ResponseEntity.ok().body(
            PaymentTransactionCallbackResponse(
                PaymentTransactionCallbackResponseData(
                    status = OperationStatus.SUCCESS,
                ),
            ),
        )



        /*return ResponseEntity.ok(
            PaymentTransactionCallbackResponse(
                PaymentTransactionCallbackResponseData(
                    status = OperationStatus.SUCCESS,
                ),
            ),
        )*/
    }

    companion object {
        internal const val ENDPOINT_PAYMENT_TRANSACTION_CALLBACK = "/payment-transactions/{transactionId}/callback"
        internal const val ENDPOINT_PAYMENT_SUB_REFUND_CALLBACK = "/sub-refund-transactions/{transactionId}/callback"
    }
}
