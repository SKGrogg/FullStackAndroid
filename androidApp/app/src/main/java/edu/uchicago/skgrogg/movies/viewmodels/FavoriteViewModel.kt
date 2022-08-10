package edu.uchicago.skgrogg.movies.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uchicago.skgrogg.favs.data.repository.FavoritesRepository
import edu.uchicago.skgrogg.movies.models.Favorite
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriteViewModel: ViewModel() {

    val mFavorites = MutableLiveData<List<Favorite>?>()

    init {
        getFavorites()
    }

    private fun getFavorites() {
        FavoritesRepository().getFavorites().enqueue(object: Callback<List<Favorite>> {
            override fun onResponse(
                call: Call<List<Favorite>>,
                response: Response<List<Favorite>>
            ) {
                val favorites = response.body()
                favorites.let{
                    mFavorites.value = favorites
                }
            }

            override fun onFailure(call: Call<List<Favorite>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}