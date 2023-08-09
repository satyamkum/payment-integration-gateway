package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.deliveryhero.paymentgateway.models.Money
import com.deliveryhero.paymentgateway.models.enums.BalanceType
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

sealed class Balance(
    @JsonProperty("type") val type: BalanceType,
    @JsonProperty("amount") val amount: Money
)

class AvailableBalance(
    @JsonProperty("amount") amount: Money,
) : Balance(BalanceType.Available, amount)

class ExpiringBalance(
    @JsonProperty("amount") amount: Money,
    @JsonProperty("expiresAt") val expiresAt: Date? = null
) : Balance(BalanceType.Expiring, amount)

class WithholdingBalance(
    @JsonProperty("amount") amount: Money,
) : Balance(BalanceType.Withholding, amount)

data class Balances(
    @JsonProperty("available") val available: AvailableBalance?,
    @JsonProperty("expiring") val expiring: ExpiringBalance?,
    @JsonProperty("withholding") val withholding: WithholdingBalance?
)
