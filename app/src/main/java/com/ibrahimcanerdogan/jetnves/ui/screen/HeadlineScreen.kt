package com.ibrahimcanerdogan.jetnves.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews
import com.ibrahimcanerdogan.jetnves.ui.component.common.ErrorScreen
import com.ibrahimcanerdogan.jetnves.ui.component.common.LoadingScreen
import com.ibrahimcanerdogan.jetnves.ui.viewmodel.HeadlineViewModel
import com.ibrahimcanerdogan.jetnves.util.LOGTAG
import com.ibrahimcanerdogan.jetnves.util.Resource
import com.ibrahimcanerdogan.jetnves.util.logMessage

@Composable
fun HeadlineScreen(
    headlineViewModel: HeadlineViewModel
) {
    val headlineNewsState by headlineViewModel.headlineNews.observeAsState()

    LaunchedEffect(Unit) {
        headlineViewModel.getTopHeadlines()
    }

    when (headlineNewsState) {
        is Resource.Loading -> {
            LoadingScreen()
        }
        is Resource.Success -> {
            val news = (headlineNewsState as Resource.Success<HeadlineNews>).data
            // NewsList(news = news.articles)
            news.newsArticles?.forEach {
                logMessage(LOGTAG.LAYER_VIEW, it?.articleTitle.toString())
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