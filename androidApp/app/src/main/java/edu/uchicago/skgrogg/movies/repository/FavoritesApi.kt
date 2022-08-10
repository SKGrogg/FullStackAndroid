package edu.uchicago.skgrogg.favs.data.repository

import edu.uchicago.skgrogg.movies.models.Favorite
import edu.uchicago.skgrogg.movies.models.MoviesResponse
import okhttp3.ResponseBody
import retrofit2.Call

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface FavoritesApi {

    //this will manage generating the query string and using Retrofit to send GET request to api
    @GET(value = "{user}")
    fun getFavorites(@Path("user") user: String): Call<List<Favorite>>
}