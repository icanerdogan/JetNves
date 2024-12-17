package com.ibrahimcanerdogan.jetnves.data.repository.headline.datasource

import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.util.Resource
import kotlinx.coroutines.flow.Flow

interface RemoteHeadlineDataSource {

    suspend fun getRemoteTopHeadlines() : Flow<Resource<HeadlineNews>>
}