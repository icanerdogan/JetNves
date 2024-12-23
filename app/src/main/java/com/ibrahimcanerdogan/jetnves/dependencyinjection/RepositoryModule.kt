package com.ibrahimcanerdogan.jetnves.dependencyinjection

import com.ibrahimcanerdogan.jetnves.data.repository.everything.SearchRepositoryImpl
import com.ibrahimcanerdogan.jetnves.data.repository.headline.HeadlineRepositoryImpl
import com.ibrahimcanerdogan.jetnves.data.repository.sources.SourceRepositoryImpl
import com.ibrahimcanerdogan.jetnves.domain.repository.HeadlineRepository
import com.ibrahimcanerdogan.jetnves.domain.repository.SearchRepository
import com.ibrahimcanerdogan.jetnves.domain.repository.SourceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHeadlineRepository(
        headlineRepositoryImpl: HeadlineRepositoryImpl
    ): HeadlineRepository

    @Binds
    @Singleton
    abstract fun bindSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository

    @Binds
    @Singleton
    abstract fun bindSourceRepository(
        sourceRepositoryImpl: SourceRepositoryImpl
    ): SourceRepository
}