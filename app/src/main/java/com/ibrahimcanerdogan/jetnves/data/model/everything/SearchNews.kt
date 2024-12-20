package com.ibrahimcanerdogan.jetnves.data.model.everything

import com.google.gson.annotations.SerializedName

data class SearchNews(
    @SerializedName("articles")
    val searchArticles: List<SearchArticle?>?,
    @SerializedName("status")
    val searchStatus: String?,
    @SerializedName("code")
    val searchErrorCode: String? = null,
    @SerializedName("message")
    val searchErrorMessage: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int?
)