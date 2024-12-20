package com.ibrahimcanerdogan.jetnves.data.network

import com.ibrahimcanerdogan.jetnves.BuildConfig
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsCategories
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsSortBy
import com.ibrahimcanerdogan.jetnves.data.model.everything.SearchNews
import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.data.model.source.Source
import com.ibrahimcanerdogan.jetnves.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    /*
    *TODO: Add Everything from-to date filter.
    *TODO: Sort Everything news sortBy.
    *TODO: Exclude & Include domains add.
    *TODO: Search news in everything.
    *TODO: q Keywords or a phrase to search add
    *TODO: searchIn Keywords or a phrase to search add
    *TODO: sources with after getSources method
    */

    @GET("v2/everything")
    suspend fun getSearchEverythingNews(
        @Query("q") query: String,
        @Query("page") page: Int? = 1,
        @Query("pageSize") pageSize: Int? = 100,
        // @Query("sources") sources: String = Constants.sourceCode,
        @Query("language") language: String = Constants.languageCode,
        @Query("pageSize") sortBy: String? = NewsSortBy.Popularity.sortCode,
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ): Response<SearchNews>

    /*
    *TODO: q Keywords or a phrase to search add
    *TODO: sources with after getSources method
    */

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("page") page: Int? = 1,
        @Query("pageSize") pageSize: Int? = 20,
        @Query("country") country: String = Constants.countryCode,
        // @Query("sources") sources: String = Constants.sourceCode,
        @Query("category") category: String = NewsCategories.BUSINESS.categoryCode,
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ): Response<HeadlineNews>

    /*
    *TODO: Get sources by categories.
    */

    @GET("v2/top-headlines/sources")
    suspend fun getSources(
        @Query("category") category: String = NewsCategories.BUSINESS.categoryCode,
        @Query("country") country: String = Constants.countryCode,
        @Query("language") language: String = Constants.languageCode,
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ): Response<Source>
}