package com.deliveryhero.paymentgateway.models.enums

enum class PaymentInstrumentType {
    RAW_CARD,
    TOKENIZED_CARD,
    ENCRYPTED_CARD,
    ENCRYPTED_CARD_BY_FIELD,
    FINTECH_ENCRYPTED_CARD,
    HOSTED_PAGE_CARD,
    EXTERNAL_ACCOUNT,
    ONE_TIME_PAYMENT,
    BANK_ACCOUNT,
    WALLET,
    GIFT_CARD,
    EXTERNAL_WALLET
}
