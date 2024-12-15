package com.ibrahimcanerdogan.jetnves.data.model.headline


import com.google.gson.annotations.SerializedName
import java.util.UUID

data class HeadlineArticle(
    val articleId: String = UUID.randomUUID().toString(),
    @SerializedName("author")
    val articleAuthor: String?,
    @SerializedName("content")
    val articleContent: String?,
    @SerializedName("description")
    val articleDescription: String?,
    @SerializedName("publishedAt")
    val articlePublishedAt: String?,
    @SerializedName("source")
    val articleSource: HeadlineSource?,
    @SerializedName("title")
    val articleTitle: String?,
    @SerializedName("url")
    val articleUrl: String?,
    @SerializedName("urlToImage")
    val articleUrlToImage: String?
)