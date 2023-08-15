package com.deliveryhero.paymentgateway.models.requests

import com.deliveryhero.paymentgateway.models.AdditionalData
import com.deliveryhero.paymentgateway.models.Address
import com.deliveryhero.paymentgateway.models.ClientContext
import com.deliveryhero.paymentgateway.models.DeliveryDetails
import com.deliveryhero.paymentgateway.models.FeatureDetails
import com.deliveryhero.paymentgateway.models.Money
import com.deliveryhero.paymentgateway.models.PaymentInstrument
import com.deliveryhero.paymentgateway.models.ProviderSpecificData
import com.deliveryhero.paymentgateway.models.ReturnUrlDetails
import com.deliveryhero.paymentgateway.models.RiskDetails
import com.deliveryhero.paymentgateway.models.VendorDetails
import com.deliveryhero.paymentgateway.models.enums.OperationType

data class AuthorizationRequest(
    val paymentMethod: String,
    val platformReferenceId: String,
    val amount: Money,
    val paymentInstrument: PaymentInstrument? = null,
    /*val deliveryDetails: DeliveryDetails? = null,
    val billingAddress: Address? = null,
    val returnUrlDetails: ReturnUrlDetails? = null,
    val vendorDetails: VendorDetails? = null,
    val clientContext: ClientContext? = null,
    val riskDetails: RiskDetails? = null,
    val additionalData: AdditionalData? = null,
    val featureDetails: FeatureDetails? = null,
    val providerSpecificData: ProviderSpecificData? = null,*/
    override val paymentTransactionId: String
) : BaseRequest(paymentTransactionId)
