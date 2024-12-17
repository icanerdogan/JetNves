package com.ibrahimcanerdogan.jetnves.domain.repository

import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.util.Resource
import kotlinx.coroutines.flow.Flow

interface HeadlineRepository {

    suspend fun getTopHeadlines(): Flow<Resource<HeadlineNews>>
}