package com.ibrahimcanerdogan.jetnves.data.repository.headline

import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.data.repository.headline.datasource.RemoteHeadlineDataSource
import com.ibrahimcanerdogan.jetnves.domain.repository.HeadlineRepository
import com.ibrahimcanerdogan.jetnves.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HeadlineRepositoryImpl @Inject constructor(
    private val remoteHeadlineDataSource: RemoteHeadlineDataSource
) : HeadlineRepository {

    override suspend fun getTopHeadlines(): Flow<Resource<HeadlineNews>> {
        return remoteHeadlineDataSource.getRemoteTopHeadlines()
    }
}