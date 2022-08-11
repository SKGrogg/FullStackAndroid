package edu.uchicago.skgrogg.movies.screens.favorites.paging

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.PagingSource
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import edu.uchicago.skgrogg.favs.presentation.search.SearchOperationMovie
import edu.uchicago.skgrogg.movies.navagation.Screen
import edu.uchicago.skgrogg.favs.screens.MovieRow
import edu.uchicago.skgrogg.movies.viewmodels.FavoriteViewModel
import edu.uchicago.skgrogg.movies.viewmodels.MovieViewModel


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FavoriteList(favoritesViewModel: FavoriteViewModel, navController: NavController) {
        Log.d("Favorites Loading", "Favorite List")

        val response = favoritesViewModel.favoritesRepository.getFavorites()

        if (response.isExecuted) {
            favoritesViewModel.getFavorites();
            val favorites = favoritesViewModel.getList().value
            favorites?.forEach{ favorite ->
               FavoriteRow(favorite)
            }
        }
}
