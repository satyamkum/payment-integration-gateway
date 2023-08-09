package com.deliveryhero.paymentgateway.models

import java.io.Serializable

data class VendorDetails(
    val vendorId: String,
    val vendorName: String? = null,
    val vendorAddress: Address? = null
) : Serializable
