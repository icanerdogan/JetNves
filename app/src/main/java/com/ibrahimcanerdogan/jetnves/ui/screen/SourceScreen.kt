package com.ibrahimcanerdogan.jetnves.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ibrahimcanerdogan.jetnves.ui.component.common.ErrorScreen
import com.ibrahimcanerdogan.jetnves.ui.component.common.LoadingScreen
import com.ibrahimcanerdogan.jetnves.ui.viewmodel.SourceViewModel
import com.ibrahimcanerdogan.jetnves.util.LOGTAG
import com.ibrahimcanerdogan.jetnves.util.Resource
import com.ibrahimcanerdogan.jetnves.util.logMessage

@Composable
fun SourceScreen(
    viewModel: SourceViewModel)
{

    val sources by viewModel.sources.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchSources()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when (sources) {
            is Resource.Loading -> {
                LoadingScreen()
            }
            is Resource.Success -> {
                val sourceData = (sources as Resource.Success).data
                LazyColumn {
                    items(sourceData) { source ->
                        Text(text = source.name ?: "No Name")
                    }
                }
            }
            is Resource.Error -> {
                ErrorScreen((sources as Resource.Error).message) {
                    viewModel.fetchSources()
                }
            }
            else -> {
                logMessage(LOGTAG.LAYER_VIEW, "Idle")
            }
        }
    }
}
