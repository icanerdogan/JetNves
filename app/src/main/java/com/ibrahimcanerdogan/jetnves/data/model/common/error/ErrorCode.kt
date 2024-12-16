package com.ibrahimcanerdogan.jetnves.data.model.common.error

enum class ErrorCode(val code: String) {
    ApiKeyDisabled("apiKeyDisabled"),
    ApiKeyExhausted("apiKeyExhausted"),
    ApiKeyInvalid("apiKeyInvalid"),
    ApiKeyMissing("apiKeyMissing"),
    ParameterInvalid("parameterInvalid"),
    ParametersMissing("parametersMissing"),
    RateLimited("rateLimited"),
    SourcesTooMany("sourcesTooMany"),
    SourceDoesNotExist("sourceDoesNotExist"),
    UnexpectedError("unexpectedError");

    companion object {
        fun fromErrorCode(code: String): ErrorCode? {
            return entries.find { it.code == code }
        }
    }
}
