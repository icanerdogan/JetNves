package com.ibrahimcanerdogan.jetnves.data.network

import com.ibrahimcanerdogan.jetnves.BuildConfig
import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.data.model.NewsCategory
import com.ibrahimcanerdogan.jetnves.util.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country: String = "us",
        @Query("category")
        category: String = NewsCategory.BUSINESS.param,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.NEWS_API_KEY
    ): Result<Response<HeadlineNews>>

}