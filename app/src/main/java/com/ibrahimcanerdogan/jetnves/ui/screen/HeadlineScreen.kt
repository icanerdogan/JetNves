package com.ibrahimcanerdogan.jetnves.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.ui.component.common.ErrorScreen
import com.ibrahimcanerdogan.jetnves.ui.component.common.LoadingScreen
import com.ibrahimcanerdogan.jetnves.ui.viewmodel.HeadlineViewModel
import com.ibrahimcanerdogan.jetnves.util.Resource

@Composable
fun HeadlineScreen(
    headlineViewModel: HeadlineViewModel
) {
    val headlineNewsState by headlineViewModel.headlineNews.observeAsState()

    LaunchedEffect(Unit) {
        headlineViewModel.getTopHeadlines()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when (headlineNewsState) {
            is Resource.Loading -> {
                LoadingScreen()
            }
            is Resource.Success -> {
                val news = (headlineNewsState as Resource.Success<HeadlineNews>).data
                LazyColumn {
                    items(news.newsArticles ?: emptyList()) { article ->
                        Text(text = article?.articleTitle ?: "No Title")
                    }
                }
            }
            is Resource.Error -> {
                val errorMessage = (headlineNewsState as Resource.Error).message
                ErrorScreen(message = errorMessage) {
                    headlineViewModel.getTopHeadlines()
                }
            }
            else -> {
                // Handle empty or uninitialized state if needed
            }
        }
    }

}