package com.deliveryhero.paymentgateway.models

import java.io.Serializable

data class RiskDetails(
    val shouldRequest3ds: Boolean = false,
    val threeDsData: ThreeDsData? = null
) : Serializable
