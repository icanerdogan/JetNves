package com.ibrahimcanerdogan.jetnves.data.model.everything


import com.google.gson.annotations.SerializedName

data class SearchSource(
    @SerializedName("id")
    val searchId: String?,
    @SerializedName("name")
    val searchName: String?
)