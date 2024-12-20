package com.ibrahimcanerdogan.jetnves.data.repository.sources

import android.content.Context
import com.ibrahimcanerdogan.jetnves.R
import com.ibrahimcanerdogan.jetnves.data.model.source.Source
import com.ibrahimcanerdogan.jetnves.data.repository.sources.datasource.RemoteSourceDataSource
import com.ibrahimcanerdogan.jetnves.domain.repository.SourceRepository
import com.ibrahimcanerdogan.jetnves.util.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SourceRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val remoteSourceDataSource: RemoteSourceDataSource
) : SourceRepository {

    override suspend fun getSources(category: String): Flow<Resource<Source>> {
        return flow {
            emit(Resource.Loading)
            try {
                val response = remoteSourceDataSource.getSources(category)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Resource.Success(it))
                    } ?: emit(Resource.Error(context.getString(R.string.str_warning_response_unsuccessful)))

                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: context.getString(R.string.str_error_unknown)))
            }
        }.flowOn(Dispatchers.IO)
    }
}