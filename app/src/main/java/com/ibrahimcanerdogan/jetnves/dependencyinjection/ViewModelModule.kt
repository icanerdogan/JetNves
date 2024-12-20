package com.ibrahimcanerdogan.jetnves.dependencyinjection

import com.ibrahimcanerdogan.jetnves.domain.usecase.GetSearchNewsUseCase
import com.ibrahimcanerdogan.jetnves.domain.usecase.GetTopHeadlinesUseCase
import com.ibrahimcanerdogan.jetnves.ui.viewmodel.HeadlineViewModel
import com.ibrahimcanerdogan.jetnves.ui.viewmodel.SearchViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideHeadlineViewModel(
        getTopHeadlinesUseCase: GetTopHeadlinesUseCase
    ): HeadlineViewModel {
        return HeadlineViewModel(getTopHeadlinesUseCase)
    }

    @Provides
    fun provideSearchViewModel(
        getSearchNewsUseCase: GetSearchNewsUseCase
    ): SearchViewModel {
        return SearchViewModel(getSearchNewsUseCase)
    }
}
