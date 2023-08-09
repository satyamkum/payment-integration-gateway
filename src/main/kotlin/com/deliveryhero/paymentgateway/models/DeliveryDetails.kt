package com.deliveryhero.paymentgateway.models

import com.deliveryhero.paymentgateway.models.enums.DeliveryType
import java.io.Serializable

data class DeliveryDetails(
    val deliveryType: DeliveryType,
    val deliveryAddress: Address? = null
) : Serializable
