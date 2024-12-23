package com.ibrahimcanerdogan.jetnves.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsCategories
import com.ibrahimcanerdogan.jetnves.data.model.source.SourceData
import com.ibrahimcanerdogan.jetnves.domain.usecase.GetSourceNewsUseCase
import com.ibrahimcanerdogan.jetnves.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SourceViewModel @Inject constructor(
    private val getSourceNewsUseCase: GetSourceNewsUseCase
) : ViewModel() {

    private val _sources = MutableStateFlow<Resource<List<SourceData>>>(Resource.Idle)
    val sources: StateFlow<Resource<List<SourceData>>> get() = _sources

    init {
        fetchSources()
    }

    fun fetchSources(category: String = NewsCategories.GENERAL.name) {
        viewModelScope.launch {
            getSourceNewsUseCase(category).collect { resource ->
                _sources.value = resource
            }
        }
    }
}
