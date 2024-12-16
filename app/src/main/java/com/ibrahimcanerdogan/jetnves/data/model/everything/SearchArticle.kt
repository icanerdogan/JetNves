package com.ibrahimcanerdogan.jetnves.data.model.everything


import com.google.gson.annotations.SerializedName

data class SearchArticle(
    @SerializedName("author")
    val searchAuthor: String?,
    @SerializedName("content")
    val searchContent: String?,
    @SerializedName("description")
    val searchDescription: String?,
    @SerializedName("publishedAt")
    val searchPublishedAt: String?,
    @SerializedName("source")
    val searchSource: SearchSource?,
    @SerializedName("title")
    val searchTitle: String?,
    @SerializedName("url")
    val searchUrl: String?,
    @SerializedName("urlToImage")
    val searchUrlToImage: String?
)