package com.ibrahimcanerdogan.jetnves.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.domain.usecase.GetTopHeadlinesUseCase
import com.ibrahimcanerdogan.jetnves.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeadlineViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase
) : ViewModel() {

    private val _headlineNews = MutableLiveData<Resource<HeadlineNews>>()
    val headlineNews: LiveData<Resource<HeadlineNews>> get() = _headlineNews

    fun getTopHeadlines() {
        viewModelScope.launch {
            getTopHeadlinesUseCase.execute()
                .collect { result ->
                    _headlineNews.value = result
                }
        }
    }
}