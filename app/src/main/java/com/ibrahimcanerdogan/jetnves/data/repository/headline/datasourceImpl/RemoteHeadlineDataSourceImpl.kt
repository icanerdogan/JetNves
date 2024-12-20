package com.ibrahimcanerdogan.jetnves.data.repository.headline.datasourceImpl

import android.content.Context
import com.ibrahimcanerdogan.jetnves.R
import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.data.network.APIService
import com.ibrahimcanerdogan.jetnves.data.repository.headline.datasource.RemoteHeadlineDataSource
import com.ibrahimcanerdogan.jetnves.util.LOGTAG
import com.ibrahimcanerdogan.jetnves.util.Resource
import com.ibrahimcanerdogan.jetnves.util.logMessage
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteHeadlineDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val apiService: APIService
): RemoteHeadlineDataSource {

    override suspend fun getRemoteTopHeadlines(): Flow<Resource<HeadlineNews>> = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.getTopHeadlines()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val filteredHeadlineNews = filterNewsBody(body)
                    emit(Resource.Success(filteredHeadlineNews))
                    
                } else {
                    emit(Resource.Error(context.getString(R.string.str_warning_empty_body)))
                }
            } else {
                emit(Resource.Error(context.getString(R.string.str_warning_response_unsuccessful)))
                logMessage(LOGTAG.LAYER_DOMAIN, response.message())
            }
        } catch (e: Exception) {
            emit(Resource.Error(context.getString(R.string.str_warning_response_unsuccessful)))
            logMessage(LOGTAG.LAYER_DOMAIN, message = e.localizedMessage ?: e.message.toString())
        }
    }

    private fun filterNewsBody(body: HeadlineNews): HeadlineNews {
        val filteredBody = body.newsArticles?.filter {
            it?.articleTitle != "[Removed]"
        }
        val filteredHeadlineNews = HeadlineNews(
            newsArticles = filteredBody,
            newsStatus = body.newsStatus,
            newsErrorCode = body.newsErrorCode,
            newsErrorMessage = body.newsErrorMessage,
            newsTotalResults = filteredBody?.size
        )
        return filteredHeadlineNews
    }
}