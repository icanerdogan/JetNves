package com.ibrahimcanerdogan.jetnves.data.repository.sources.datasourceImpl

import com.ibrahimcanerdogan.jetnves.data.model.source.Source
import com.ibrahimcanerdogan.jetnves.data.network.APIService
import com.ibrahimcanerdogan.jetnves.data.repository.sources.datasource.RemoteSourceDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteSourceDataSourceImpl @Inject constructor(
    private val apiService: APIService
) : RemoteSourceDataSource {

    override suspend fun getSources(category: String): Response<Source> {
        return apiService.getSources(category)
    }
}