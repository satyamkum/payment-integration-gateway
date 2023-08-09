package com.deliveryhero.paymentgateway.models
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

class SecuredString @JsonCreator(mode = JsonCreator.Mode.DELEGATING) constructor(value: String?) {

    val value: String? = applyMask(value)

    override fun toString() = if (this.value == null) this.value.toString() else "********"
    override fun equals(other: Any?): Boolean = other is SecuredString && this.value == other.value
    override fun hashCode(): Int = value.hashCode()

    @JsonValue
    fun unmask(): String? = applyMask(value)

    companion object {
        private val maskKey = "some key"
        private val defaultMaskKey = "b7dc2dde9b8059a3439a9785aa29a5d9"

        private fun applyMask(input: String?): String? {
            if (maskKey == defaultMaskKey) {
                //logger.error("Missing SECURED_STRING_MASK_KEY in environment variables - Using default value")
            }

            if (input == null) return null

            return input.mapIndexed { index, char ->
                char xor maskKey[index % maskKey.length]
            }.joinToString("")
        }

        private infix fun Char.xor(other: Char) = (this.toInt() xor other.toInt()).toChar()
    }
}

fun SecuredString?.isNullOrBlank(): Boolean = this?.value.isNullOrBlank()
fun SecuredString?.isNullOrEmpty() = this?.value.isNullOrEmpty()
fun SecuredString?.isBlank() = this?.value == null || this?.value.isBlank()
fun SecuredString?.toLowerCase() = this?.value?.lowercase()
