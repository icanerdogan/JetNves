package com.ibrahimcanerdogan.jetnves.data.repository.everything.datasourceImpl

import android.content.Context
import com.ibrahimcanerdogan.jetnves.R
import com.ibrahimcanerdogan.jetnves.data.model.everything.SearchNews
import com.ibrahimcanerdogan.jetnves.data.network.APIService
import com.ibrahimcanerdogan.jetnves.data.repository.everything.datasource.RemoteSearchDataSource
import com.ibrahimcanerdogan.jetnves.util.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RemoteSearchDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val apiService: APIService
): RemoteSearchDataSource {

    override suspend fun getSearchEverythingNews(
        query: String,
        page: Int,
        pageSize: Int
    ): Resource<SearchNews> {
        return try {
            val response = apiService.getSearchEverythingNews(query, page, pageSize)
            if (response.isSuccessful) {
                response.body()?.let {
                    val filteredSearchNews = filterSearchBody(it)
                    Resource.Success(filteredSearchNews)
                } ?: Resource.Error(context.getString(R.string.str_warning_empty_body))
            } else {
                Resource.Error(response.errorBody()?.string() ?: context.getString(R.string.str_error_unknown))
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: context.getString(R.string.str_error_unknown))
        }
    }

    private fun filterSearchBody(body: SearchNews): SearchNews {
        val filteredBody = body.searchArticles?.filter {
            it?.searchTitle != "[Removed]"
        }
        val filteredHeadlineNews = SearchNews(
            searchArticles = filteredBody,
            searchStatus = body.searchStatus,
            searchErrorCode = body.searchErrorCode,
            searchErrorMessage = body.searchErrorMessage,
            totalResults = filteredBody?.size
        )
        return filteredHeadlineNews
    }
}
