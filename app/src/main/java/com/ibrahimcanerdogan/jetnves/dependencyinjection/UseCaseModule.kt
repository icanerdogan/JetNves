package com.ibrahimcanerdogan.jetnves.dependencyinjection

import com.ibrahimcanerdogan.jetnves.domain.repository.HeadlineRepository
import com.ibrahimcanerdogan.jetnves.domain.repository.SearchRepository
import com.ibrahimcanerdogan.jetnves.domain.repository.SourceRepository
import com.ibrahimcanerdogan.jetnves.domain.usecase.GetSearchNewsUseCase
import com.ibrahimcanerdogan.jetnves.domain.usecase.GetSourceNewsUseCase
import com.ibrahimcanerdogan.jetnves.domain.usecase.GetTopHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetTopHeadlinesUseCase(
        headlineRepository: HeadlineRepository
    ): GetTopHeadlinesUseCase {
        return GetTopHeadlinesUseCase(headlineRepository)
    }

    @Provides
    fun provideGetSearchEverythingNewsUseCase(
        searchRepository: SearchRepository
    ): GetSearchNewsUseCase {
        return GetSearchNewsUseCase(searchRepository)
    }

    @Provides
    fun provideGetSourceNewsUseCase(
        sourceRepository: SourceRepository
    ): GetSourceNewsUseCase {
        return GetSourceNewsUseCase(sourceRepository)
    }
}