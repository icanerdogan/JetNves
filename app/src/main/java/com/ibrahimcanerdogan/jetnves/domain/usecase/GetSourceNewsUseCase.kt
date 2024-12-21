package com.ibrahimcanerdogan.jetnves.domain.usecase

import com.ibrahimcanerdogan.jetnves.data.model.source.Source
import com.ibrahimcanerdogan.jetnves.data.model.source.SourceData
import com.ibrahimcanerdogan.jetnves.domain.repository.SourceRepository
import com.ibrahimcanerdogan.jetnves.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSourceNewsUseCase @Inject constructor(
    private val repository: SourceRepository
) {

    suspend operator fun invoke(
        category: String
    ): Flow<Resource<List<SourceData>>> {
        return repository.getSources(category)
    }
}