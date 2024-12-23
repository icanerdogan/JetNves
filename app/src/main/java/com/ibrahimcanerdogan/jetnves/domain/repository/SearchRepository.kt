package com.ibrahimcanerdogan.jetnves.domain.repository

import com.ibrahimcanerdogan.jetnves.data.model.everything.SearchNews
import com.ibrahimcanerdogan.jetnves.util.Resource

interface SearchRepository {

    suspend fun getSearchEverythingNews(
        query: String,
        page: Int,
        pageSize: Int
    ): Resource<SearchNews>

}