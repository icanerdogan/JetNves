package com.ibrahimcanerdogan.jetnves.domain.usecase

import com.ibrahimcanerdogan.jetnves.data.model.everything.SearchNews
import com.ibrahimcanerdogan.jetnves.domain.repository.SearchRepository
import com.ibrahimcanerdogan.jetnves.util.Resource
import javax.inject.Inject

class GetSearchNewsUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int,
        pageSize: Int
    ): Resource<SearchNews> {
        return repository.getSearchEverythingNews(query, page, pageSize)
    }
}
