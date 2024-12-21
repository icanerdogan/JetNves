package com.ibrahimcanerdogan.jetnves.data.repository.sources.datasourceImpl

import com.ibrahimcanerdogan.jetnves.data.database.source.SourceDao
import com.ibrahimcanerdogan.jetnves.data.model.source.SourceData
import com.ibrahimcanerdogan.jetnves.data.repository.sources.datasource.LocalSourceDataSource
import javax.inject.Inject

class LocalSourceDataSourceImpl @Inject constructor(
    private val sourceDao: SourceDao
): LocalSourceDataSource {

    override suspend fun clearAllDataDB() {
        sourceDao.clearAllDatabase()
    }

    override suspend fun getSourcesFromDB(category: String): List<SourceData> {
        return sourceDao.getAllSourcesByCategoryDatabase(category)
    }

    override suspend fun saveSourcesToDB(sources: List<SourceData>) {
        return sourceDao.insertAllDatabase(sources)
    }
}