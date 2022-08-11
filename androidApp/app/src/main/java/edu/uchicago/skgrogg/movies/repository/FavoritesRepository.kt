package edu.uchicago.skgrogg.favs.data.repository


import android.util.Log
import edu.uchicago.skgrogg.movies.common.Constants
import edu.uchicago.skgrogg.movies.models.Favorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//simple movies repo
class FavoritesRepository{

    val mClient = FavoritesClient().favoritesApi().build().create(FavoritesApi::class.java)

    fun getFavorites(): Call<List<Favorite>>{
        return mClient.getFavorites(Constants.userEmial)
    }
}



