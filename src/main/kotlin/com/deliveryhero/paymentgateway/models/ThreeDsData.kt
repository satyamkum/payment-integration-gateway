package com.deliveryhero.paymentgateway.models

data class ThreeDsData(
    val md: String? = null,
    val paRes: String? = null,
    var isShouldSendBrowserInfo: Boolean,
    var browserUserAgent: String? = null,
    var browserAcceptHeader: String? = null,
    var returnUrl: String? = null,
    val eci: String? = null,
    val xid: String? = null,
    val cavv: String? = null
)
