package com.ibrahimcanerdogan.jetnves.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.ibrahimcanerdogan.jetnves.ui.component.common.ErrorScreen
import com.ibrahimcanerdogan.jetnves.ui.component.common.LoadingScreen
import com.ibrahimcanerdogan.jetnves.ui.viewmodel.SearchViewModel
import com.ibrahimcanerdogan.jetnves.util.LOGTAG
import com.ibrahimcanerdogan.jetnves.util.Resource
import com.ibrahimcanerdogan.jetnves.util.logMessage

@Composable
fun SearchScreen(
    viewModel: SearchViewModel
) {
    val searchState by viewModel.newsState

    when (searchState) {
        is Resource.Loading -> {
            LoadingScreen()
        }
        is Resource.Success -> {
            LazyColumn {
                items((searchState as Resource.Success).data.searchArticles ?: emptyList()) { article ->
                    Text(text = article?.searchTitle ?: "No Title")
                }
            }
        }
        is Resource.Error -> {
            val errorMessage = (searchState as Resource.Error).message
            ErrorScreen(message = errorMessage) {
                viewModel.fetchNews("google")
            }
        }

        Resource.Idle -> {
            logMessage(LOGTAG.LAYER_VIEW, "Idle")
        }
    }
}
