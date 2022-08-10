package edu.uchicago.skgrogg.favs.presentation.screens.details


import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import edu.uchicago.skgrogg.movies.viewmodels.FavoriteViewModel
import edu.uchicago.skgrogg.movies.viewmodels.MovieViewModel


@Composable
fun DetailsScreen(
    navController: NavController,
    movieViewModel: MovieViewModel,
    favoriteViewModel: FavoriteViewModel
) {

    //observe the movie
    val movie = movieViewModel.movie.value
    val activity = (LocalContext.current as? Activity)


    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 1.dp
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {

                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier
                        .clickable {
                            navController.popBackStack()
                        }
                        .align(Alignment.CenterVertically)
                        .padding(20.dp, 0.dp, 0.dp, 0.dp))

                Text(
                    text = "Details",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {

                    Icon(imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        modifier = Modifier
                            .clickable {
                                val sendIntent = Intent(Intent.ACTION_SEND)
                                sendIntent.type = "text/plain"
                                sendIntent.putExtra(
                                    Intent.EXTRA_TEXT,
                                    "You must check out this Movie!: ${movie.title}"
                                )
                                activity?.startActivity(sendIntent)
                            }
                            .align(Alignment.CenterVertically)
                            .padding(10.dp, 0.dp, 0.dp, 0.dp))
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(imageVector = Icons.Default.Info,
                        contentDescription = "More Information",
                        modifier = Modifier
                            .clickable {
                                val sendIntent = Intent(Intent.ACTION_WEB_SEARCH)
                                sendIntent.putExtra(SearchManager.QUERY, movie.title) // query contains search string
                                //sendIntent.data = Uri.parse("google.com/search?q="+movie.title.filter { !it.isWhitespace() })
                                activity?.startActivity(sendIntent)
                            }
                            .align(Alignment.CenterVertically)
                            .padding(10.dp, 0.dp, 0.dp, 0.dp))
                }
                }

            }


    }) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(state = rememberScrollState(0))
                .padding(20.dp, 0.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {


                Divider()
                Spacer(Modifier.height(20.dp))
                //we can use either coil or glide for images. If you need animations, use coil
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp),
                    imageModel = "https://image.tmdb.org/t/p/original" + movie.posterPath ?: "https://picsum.photos/id/1026/200/300",
                    // Crop, Fit, Inside, FillHeight, FillWidth, None
                    contentScale = ContentScale.Fit

                )
                with(movie){
                   title?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp
                        )
                    }
                    overview.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.Normal),
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp
                        )
                    }
                }

                Button(
                    modifier =
                    Modifier
                        .padding(10.dp, 0.dp)
                        .fillMaxWidth(1f),

                    onClick = { favoriteViewModel.onSubmit(movie, movieViewModel.queryText.value, "Seany Boy") },

                    colors =
                        ButtonDefaults.buttonColors(backgroundColor = Color.Green)

                ) {
                        Text(text = "Add to Favorites")
                }

            }
        }
    }

}




