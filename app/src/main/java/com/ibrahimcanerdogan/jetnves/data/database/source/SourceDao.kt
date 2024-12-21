package com.ibrahimcanerdogan.jetnves.data.database.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.jetnves.data.model.source.SourceData
import com.ibrahimcanerdogan.jetnves.util.Constants

@Dao
interface SourceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDatabase(sources: List<SourceData>)

    @Query("SELECT * FROM source_data WHERE " +
            "source_category = :category AND " +
            "source_language = :language AND " +
            "source_country = :country"
    )
    suspend fun getAllSourcesByCategoryDatabase(
        category: String,
        country: String = Constants.countryCode,
        language: String = Constants.languageCode,
    ): List<SourceData>

    @Query("DELETE FROM source_data")
    suspend fun clearAllDatabase()
}
