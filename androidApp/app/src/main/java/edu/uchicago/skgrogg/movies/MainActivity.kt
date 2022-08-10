package edu.uchicago.skgrogg.movies


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.uchicago.skgrogg.favs.data.repository.FavoritesApi
import edu.uchicago.skgrogg.favs.data.repository.FavoritesClient

import edu.uchicago.skgrogg.favs.screens.Navigation
import edu.uchicago.skgrogg.movies.models.Favorite
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Surface(color = MaterialTheme.colors.background) {
                Navigation(navController = navController)
            }

        }

        getFavorites()
    }

    fun getFavorites(){
        val client = FavoritesClient().favoritesApi().build().create(FavoritesApi::class.java)
        client.getFavorites("Seany Boy").enqueue(object: Callback<List<Favorite>>{
            override fun onResponse(
                call: Call<List<Favorite>>,
                response: Response<List<Favorite>>
            ) {
                val favorites = response.body()
                favorites?.let{
                    for (favorite in favorites){
                        Log.d("Main Activity", "onResponse: ${favorite.title}")
                    }
                }
            }

            override fun onFailure(call: Call<List<Favorite>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}


