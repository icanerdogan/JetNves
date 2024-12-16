package com.ibrahimcanerdogan.jetnves.data.network

import com.ibrahimcanerdogan.jetnves.BuildConfig
import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsCategories
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsCountries
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsLanguages
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsSortBy
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsSources
import com.ibrahimcanerdogan.jetnves.util.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    /*
    *TODO: Add Everything from-to date filter.
    *TODO: Sort Everything news sortBy.
    *TODO: Exclude & Include domains add.
    *TODO: Search news in everything.
    */

    @GET("v2/everything")
    suspend fun getSearchEverythingNews(
        @Query("q") query: String? = null,
        @Query("page") page: Int? = 1,
        @Query("pageSize") pageSize: Int? = 100,
        @Query("language") language: String? = NewsLanguages.EN.lanCode,
        @Query("pageSize") sortBy: String? = NewsSortBy.Popularity.sortCode,
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ): Result<HeadlineNews>

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int? = 20,
        @Query("country") country: String = NewsCountries.US.countryCode,
        @Query("category") category: String = NewsCategories.BUSINESS.categoryCode,
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ): Result<HeadlineNews>

    /*
    *TODO: Get sources by categories.
    */

    @GET("v2/top-headlines/sources")
    suspend fun getSources(
        @Query("country") country: String = NewsCountries.US.countryCode,
        @Query("language") language: String = NewsLanguages.EN.lanCode,
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ): Result<HeadlineNews>
}