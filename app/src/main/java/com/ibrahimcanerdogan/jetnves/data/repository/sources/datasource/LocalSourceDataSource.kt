package com.ibrahimcanerdogan.jetnves.data.repository.sources.datasource

import com.ibrahimcanerdogan.jetnves.data.model.source.SourceData

interface LocalSourceDataSource {

    suspend fun getSourcesFromDB(category: String): List<SourceData>
    suspend fun saveSourcesToDB(sources: List<SourceData>)
    suspend fun clearAllDataDB()

}