package edu.uchicago.skgrogg.favs.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import edu.uchicago.skgrogg.favs.presentation.screens.details.DetailsScreen
import edu.uchicago.skgrogg.favs.presentation.screens.favorites.FavoritesScreen
import edu.uchicago.skgrogg.favs.presentation.screens.contact.ContactScreen
import edu.uchicago.skgrogg.favs.presentation.screens.search.SearchScreen
import edu.uchicago.skgrogg.movies.navagation.Screen
import edu.uchicago.skgrogg.movies.viewmodels.MovieViewModel


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
    navController: NavHostController
) {

    val movieViewModel: MovieViewModel = hiltViewModel()
    NavHost(navController, startDestination = Screen.Search.route) {
        composable(Screen.Search.route) {
            SearchScreen(movieViewModel = movieViewModel, navController = navController)

        }

        composable(Screen.Favorites.route) {
            FavoritesScreen(navController)
        }

        composable(Screen.Contact.route) {
            ContactScreen(navController)
        }


        composable(Screen.Detail.route) { backStackEntry ->
            DetailsScreen(navController = navController, movieViewModel = movieViewModel)
        }
    }

}
