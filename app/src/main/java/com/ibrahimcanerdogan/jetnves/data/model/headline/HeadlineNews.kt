package com.ibrahimcanerdogan.jetnves.data.model.headline

import com.google.gson.annotations.SerializedName

data class HeadlineNews(
    @SerializedName("articles")
    val newsArticles: List<HeadlineArticle?>?,
    @SerializedName("status")
    val newsStatus: String?,
    @SerializedName("totalResults")
    val newsTotalResults: Int?
)