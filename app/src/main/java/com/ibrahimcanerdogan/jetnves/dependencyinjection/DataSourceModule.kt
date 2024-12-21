package com.ibrahimcanerdogan.jetnves.dependencyinjection

import com.ibrahimcanerdogan.jetnves.data.repository.everything.datasource.RemoteSearchDataSource
import com.ibrahimcanerdogan.jetnves.data.repository.everything.datasourceImpl.RemoteSearchDataSourceImpl
import com.ibrahimcanerdogan.jetnves.data.repository.headline.datasource.RemoteHeadlineDataSource
import com.ibrahimcanerdogan.jetnves.data.repository.headline.datasourceImpl.RemoteHeadlineDataSourceImpl
import com.ibrahimcanerdogan.jetnves.data.repository.sources.datasource.LocalSourceDataSource
import com.ibrahimcanerdogan.jetnves.data.repository.sources.datasource.RemoteSourceDataSource
import com.ibrahimcanerdogan.jetnves.data.repository.sources.datasourceImpl.LocalSourceDataSourceImpl
import com.ibrahimcanerdogan.jetnves.data.repository.sources.datasourceImpl.RemoteSourceDataSourceImpl
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

    @Binds
    @Singleton
    abstract fun bindRemoteSearchDataSource(
        remoteSearchDataSourceImpl: RemoteSearchDataSourceImpl
    ): RemoteSearchDataSource

    @Binds
    @Singleton
    abstract fun bindRemoteSourceDataSource(
        remoteSourceDataSourceImpl: RemoteSourceDataSourceImpl
    ): RemoteSourceDataSource

    @Binds
    @Singleton
    abstract fun bindLocalSourceDataSource(
        localSourceDataSourceImpl: LocalSourceDataSourceImpl
    ): LocalSourceDataSource
}