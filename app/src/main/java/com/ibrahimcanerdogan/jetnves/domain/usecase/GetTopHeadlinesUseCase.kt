package com.ibrahimcanerdogan.jetnves.domain.usecase

import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.domain.repository.HeadlineRepository
import com.ibrahimcanerdogan.jetnves.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(
    private val repository: HeadlineRepository
) {

    suspend fun execute(): Flow<Resource<HeadlineNews>> {
        return repository.getTopHeadlines()
    }

}