package edu.uchicago.skgrogg.movies.screens.favorites.paging


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import edu.uchicago.skgrogg.movies.models.Favorite

import edu.uchicago.skgrogg.movies.viewmodels.FavoriteViewModel


@ExperimentalAnimationApi
@Composable
fun FavoriteRow(favorite: Favorite,
    favoriteViewModel: FavoriteViewModel)
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp, 5.dp, 10.dp),
        shape = RoundedCornerShape(corner = CornerSize(4.dp)),
        elevation = 12.dp,
        backgroundColor = MaterialTheme.colors.surface

    ) {
        Row(horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp)) {
                //we use coil library here to get fadeIn effect
                val image = rememberCoilPainter(
                    request = "https://image.tmdb.org/t/p/original" + favorite.posterPath ?: "https://picsum.photos/id/1026/60/90",
                    fadeIn = true)
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .width(60.dp)
                        .height(90.dp),
                    contentScale = ContentScale.FillHeight
                )

            }


            Column() {
                Row() {
                    Text(
                        //sometimes, the authors are null; for example when it is a United Nations report
                        text = favorite.title ?: "None",
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
                    )
                    Icon(imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        modifier = Modifier
                            .padding(15.dp, 0.dp, 0.dp, 0.dp)
                            .clickable { favoriteViewModel.onDelete(favorite) },
                        tint = Color.Red
                    )
                }

                Text(text = favorite.overview ?: "None")


            }




        }
    }
}

