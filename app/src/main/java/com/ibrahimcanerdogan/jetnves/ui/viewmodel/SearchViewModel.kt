package com.ibrahimcanerdogan.jetnves.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.jetnves.data.model.everything.SearchNews
import com.ibrahimcanerdogan.jetnves.domain.usecase.GetSearchNewsUseCase
import com.ibrahimcanerdogan.jetnves.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchNewsUseCase: GetSearchNewsUseCase
) : ViewModel() {

    private val _newsState = mutableStateOf<Resource<SearchNews>>(Resource.Idle)
    val newsState: State<Resource<SearchNews>> = _newsState

    fun fetchNews(query: String, page: Int = 1, pageSize: Int = 20) {
        viewModelScope.launch {
            _newsState.value = Resource.Loading
            val result = getSearchNewsUseCase(query, page, pageSize)
            _newsState.value = result
        }
    }
}
