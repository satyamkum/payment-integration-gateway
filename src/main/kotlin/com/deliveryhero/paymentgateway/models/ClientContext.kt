package com.deliveryhero.paymentgateway.models

import java.io.Serializable

data class ClientContext(
    val ipAddress: String? = null,
    var userAgent: String? = null,
    val acceptHeader: String? = null,
    val clientMetadataId: String? = null,
    val osType: OsType? = null,
    val osVersion: String? = null,
    val clientType: ClientType? = null,
    var colorDepth: Int? = null,
    var screenHeight: Int? = null,
    var screenWidth: Int? = null,
    var timezoneOffset: Int? = null,
    var javaEnabled: Boolean? = null,
    var language: String? = null,
    var origin: String? = null
) : Serializable
