package com.ibrahimcanerdogan.jetnves.data.repository.headline.datasourceImpl

import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.data.network.APIService
import com.ibrahimcanerdogan.jetnves.data.repository.headline.datasource.RemoteHeadlineDataSource
import com.ibrahimcanerdogan.jetnves.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteHeadlineDataSourceImpl @Inject constructor(
    private val apiService: APIService
): RemoteHeadlineDataSource {

    override suspend fun getRemoteTopHeadlines(): Flow<Resource<HeadlineNews>> = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.getTopHeadlines()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(Resource.Success(body))
                } else {
                    emit(Resource.Error("Empty response body"))
                }
            } else {
                emit(Resource.Error("API error: ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Exception: ${e.localizedMessage}"))
        }
    }
}