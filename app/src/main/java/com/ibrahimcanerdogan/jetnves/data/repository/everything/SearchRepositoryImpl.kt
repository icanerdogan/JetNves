package com.ibrahimcanerdogan.jetnves.data.repository.everything

import com.ibrahimcanerdogan.jetnves.data.model.everything.SearchNews
import com.ibrahimcanerdogan.jetnves.data.repository.everything.datasource.RemoteSearchDataSource
import com.ibrahimcanerdogan.jetnves.domain.repository.SearchRepository
import com.ibrahimcanerdogan.jetnves.util.Resource
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteSearchDataSource
) : SearchRepository {

    override suspend fun getSearchEverythingNews(
        query: String,
        page: Int,
        pageSize: Int
    ): Resource<SearchNews> {
        return remoteDataSource.getSearchEverythingNews(query, page, pageSize)
    }

}