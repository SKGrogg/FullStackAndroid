package edu.uchicago.skgrogg.favs.data.repository

import edu.uchicago.skgrogg.movies.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface MoviesApi {

    //this will manage generating the query string and using Retrofit to send GET request to api
    @GET(value = "3/discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("sort_by") sortBy: String,
        @Query("page") page: Int,
        @Query("primary_release_year") primary_release_year: String
    ): Response<MoviesResponse>
}