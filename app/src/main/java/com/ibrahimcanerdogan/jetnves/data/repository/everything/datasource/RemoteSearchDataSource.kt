package com.ibrahimcanerdogan.jetnves.data.repository.everything.datasource

import com.ibrahimcanerdogan.jetnves.data.model.everything.SearchNews
import com.ibrahimcanerdogan.jetnves.util.Resource

interface RemoteSearchDataSource {

    suspend fun getSearchEverythingNews(
        query: String,
        page: Int,
        pageSize: Int
    ): Resource<SearchNews>

}