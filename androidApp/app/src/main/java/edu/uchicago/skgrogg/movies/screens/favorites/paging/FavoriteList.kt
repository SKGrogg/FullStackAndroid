package edu.uchicago.skgrogg.movies.screens.favorites.paging

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

        favoritesViewModel.getFavorites()
        if (favoritesViewModel.mFavorites.value?.size == 0){
            Log.d("Favorites Loading", "Empty List")
            Text(text = "No Favorites Yet For This User!",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                fontSize = 20.sp)
        }else{
            Log.d("Favorites Loading", "Trying the Row Loop")
            favoritesViewModel.mFavorites.value?.forEach{ favorite ->
                FavoriteRow(favorite, favoritesViewModel)
            }
        }
        Log.d("Favorites Loading", "Response is")


}
