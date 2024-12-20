package com.ibrahimcanerdogan.jetnves.data.repository.sources.datasource

import com.ibrahimcanerdogan.jetnves.data.model.source.Source
import retrofit2.Response

interface RemoteSourceDataSource {

    suspend fun getSources(category: String): Response<Source>

}