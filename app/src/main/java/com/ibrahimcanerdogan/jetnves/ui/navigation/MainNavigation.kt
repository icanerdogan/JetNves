package com.ibrahimcanerdogan.jetnves.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ibrahimcanerdogan.jetnves.ui.screen.HeadlineScreen
import com.ibrahimcanerdogan.jetnves.ui.screen.SearchScreen
import com.ibrahimcanerdogan.jetnves.ui.screen.SourceScreen
import com.ibrahimcanerdogan.jetnves.ui.viewmodel.HeadlineViewModel
import com.ibrahimcanerdogan.jetnves.ui.viewmodel.SearchViewModel
import com.ibrahimcanerdogan.jetnves.ui.viewmodel.SourceViewModel

@Composable
fun MainNavigation(
    navController: NavHostController
) {
    // ViewModels
    val headlineViewModel: HeadlineViewModel = hiltViewModel()
    val searchViewModel: SearchViewModel = hiltViewModel()
    val sourceViewModel: SourceViewModel = hiltViewModel()

    NavHost(navController, startDestination = NavDestinations.SCREEN_HEADLINE.name) {
        composable(NavDestinations.SCREEN_HEADLINE.name) {
            HeadlineScreen(headlineViewModel)
        }
        composable(NavDestinations.SCREEN_SEARCH.name) {
            SearchScreen(searchViewModel)
        }
        composable(NavDestinations.SCREEN_SOURCE.name) {
            SourceScreen(sourceViewModel)
        }
    }

}