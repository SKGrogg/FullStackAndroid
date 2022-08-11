package edu.uchicago.skgrogg.movies.screens.favorites.paging


import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import edu.uchicago.skgrogg.movies.models.Favorite

import edu.uchicago.skgrogg.movies.models.Result


@ExperimentalAnimationApi
@Composable
fun FavoriteRow(favorite: Favorite) {
    Log.d("Favorites Loading", "Made it to Favorite Row")
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

                Text(
                    //sometimes, the authors are null; for example when it is a United Nations report
                    text = favorite.title ?: "None",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp
                )
                Text(text = favorite.overview ?: "None")
            }
        }
    }
}

