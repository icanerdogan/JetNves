package com.ibrahimcanerdogan.jetnves.domain.repository

import com.ibrahimcanerdogan.jetnves.data.model.source.Source
import com.ibrahimcanerdogan.jetnves.util.Resource
import kotlinx.coroutines.flow.Flow

interface SourceRepository {

    suspend fun getSources(category: String): Flow<Resource<Source>>

}