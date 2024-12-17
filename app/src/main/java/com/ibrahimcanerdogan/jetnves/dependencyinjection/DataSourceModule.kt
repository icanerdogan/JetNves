package com.ibrahimcanerdogan.jetnves.dependencyinjection

import com.ibrahimcanerdogan.jetnves.data.repository.headline.datasource.RemoteHeadlineDataSource
import com.ibrahimcanerdogan.jetnves.data.repository.headline.datasourceImpl.RemoteHeadlineDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteHeadlineDataSource(
        remoteHeadlineDataSourceImpl: RemoteHeadlineDataSourceImpl
    ): RemoteHeadlineDataSource

}