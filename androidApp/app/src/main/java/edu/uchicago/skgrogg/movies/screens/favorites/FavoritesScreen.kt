package edu.uchicago.skgrogg.favs.presentation.screens.favorites

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.uchicago.skgrogg.favs.presentation.search.SearchOperationMovie
import edu.uchicago.skgrogg.favs.presentation.search.widgets.MovieList
import edu.uchicago.skgrogg.movies.R
import edu.uchicago.skgrogg.movies.screens.favorites.paging.FavoriteList
import edu.uchicago.skgrogg.movies.screens.favorites.paging.SearchOperationFavorite
import edu.uchicago.skgrogg.movies.viewmodels.FavoriteViewModel
import edu.uchicago.skgrogg.movies.viewmodels.MovieViewModel
import edu.uchicago.skgrogg.movies.widgets.BottomNavigationBar

@Composable
fun FavoritesScreen(favoriteViewModel: FavoriteViewModel,
                    navController: NavController)
{
    val state = favoriteViewModel.searchState.value

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 1.dp,

                ) {
                Text(
                    text = "Favorites",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )

            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.cardview_shadow_start_color))
                .wrapContentSize(Alignment.Center)
        ) {

            when(true) {
                true -> {
                    Log.d("Favorites Loading", "Trying to Force Load")
                    FavoriteList(favoriteViewModel, navController)
                }
            }
            /*
            when (state.searchOperationFavorite) {
                SearchOperationFavorite.LOADING -> {
                    Log.d("Favorites Loading", "Made it to Loading")
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(12.dp)
                                .align(
                                    Alignment.Center
                                )
                        )
                    }
                }
                SearchOperationFavorite.DONE -> {
                    Log.d("Favorites Loading", "Made it to Done")
                    FavoriteList(favoriteViewModel, navController)
                }
                else -> {
                    Log.d("Favorites Loading", "Dropped into else")
                    Box {}
                }
            }
            */
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    //FavoritesScreen()
}