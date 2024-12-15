package com.ibrahimcanerdogan.jetnves.data.model.headline

import com.google.gson.annotations.SerializedName

data class HeadlineSource(
    @SerializedName("id")
    val sourceId: String?,
    @SerializedName("name")
    val sourceName: String?
)