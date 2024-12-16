package com.ibrahimcanerdogan.jetnves.data.model.source


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("sources")
    val sourceData: List<SourceData>?,
    @SerializedName("status")
    val sourceStatus: String?,
    @SerializedName("code")
    val sourceErrorCode: String? = null,
    @SerializedName("message")
    val sourceErrorMessage: String? = null
)