package com.ibrahimcanerdogan.jetnves.dependencyinjection

import com.ibrahimcanerdogan.jetnves.data.repository.headline.HeadlineRepositoryImpl
import com.ibrahimcanerdogan.jetnves.domain.repository.HeadlineRepository
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

}