package edu.uchicago.skgrogg.favs.presentation.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import edu.uchicago.skgrogg.favs.presentation.search.widgets.MovieList

import edu.uchicago.skgrogg.favs.screens.CustomTextField
import edu.uchicago.skgrogg.movies.viewmodels.MovieViewModel
import edu.uchicago.skgrogg.favs.presentation.search.SearchOperationMovie
import edu.uchicago.skgrogg.movies.widgets.BottomNavigationBar


@Composable
fun SearchScreen(
    movieViewModel: MovieViewModel,
    navController: NavController,
) {
    val state = movieViewModel.searchState.value
    val queryText = movieViewModel.queryText.value

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 1.dp,

                ) {
                Text(
                    text = "Search Most Popular Movies of a Year",
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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            CustomTextField(
                title = "Input Year Between 1955 and 2022",
                placeHolder = "e.g. 1984",
                textState = queryText,
                onTextChange = movieViewModel::setQueryText,
                keyboardType = KeyboardType.Number,
                ImeAction.Search,
                movieViewModel::onSearch
            )

            Spacer(modifier = Modifier.height(10.dp))
            when (state.searchOperationMovie) {
                SearchOperationMovie.LOADING -> {
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
                SearchOperationMovie.DONE -> {
                    MovieList(movieViewModel, navController)
                }
                else -> {
                    Box {}
                }
            }

        }
    }
}