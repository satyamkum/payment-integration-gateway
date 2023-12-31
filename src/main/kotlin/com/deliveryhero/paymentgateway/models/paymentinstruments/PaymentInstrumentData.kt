package com.deliveryhero.paymentgateway.models.paymentinstruments

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.io.Serializable

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    visible = true,
    property = "type"
)
@JsonSubTypes(
    Type(value = RawCard::class, name = "RAW_CARD"),
    Type(value = TokenizedCard::class, name = "TOKENIZED_CARD"),
    Type(value = EncryptedCard::class, name = "ENCRYPTED_CARD"),
    Type(value = EncryptedCardByField::class, name = "ENCRYPTED_CARD_BY_FIELD"),
    Type(value = FintechEncryptedCard::class, name = "FINTECH_ENCRYPTED_CARD"),
    Type(value = ExternalAccount::class, name = "EXTERNAL_ACCOUNT"),
    Type(value = OneTimePaymentData::class, name = "ONE_TIME_PAYMENT"),
    Type(value = BankAccount::class, name = "BANK_ACCOUNT"),
    Type(value = Wallet::class, name = "WALLET"),
    Type(value = GiftCard::class, name = "GIFT_CARD"),
    Type(value = ExternalWallet::class, name = "EXTERNAL_WALLET"),
    Type(value = CustomPaymentInstrumentData::class, name = "*")
)
abstract class PaymentInstrumentData(
    open val type: String,
    open val displayValue: String
) : Serializable
