package com.ibrahimcanerdogan.jetnves.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahimcanerdogan.jetnves.data.database.source.SourceDao
import com.ibrahimcanerdogan.jetnves.data.model.source.SourceData

@Database(entities = [SourceData::class], version = 2, exportSchema = false)
abstract class NvesDatabase : RoomDatabase() {

    abstract fun sourceDao(): SourceDao

}