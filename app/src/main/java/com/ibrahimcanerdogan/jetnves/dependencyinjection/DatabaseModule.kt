package com.ibrahimcanerdogan.jetnves.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.ibrahimcanerdogan.jetnves.data.database.NvesDatabase
import com.ibrahimcanerdogan.jetnves.data.database.source.SourceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NvesDatabase {
        return Room.databaseBuilder(
            context,
            NvesDatabase::class.java,
            "nves_database"
        ).build()
    }

    @Provides
    fun provideSourceDao(database: NvesDatabase): SourceDao {
        return database.sourceDao()
    }
}