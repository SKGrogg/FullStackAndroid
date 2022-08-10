package edu.uchicago.skgrogg.favs.data.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.uchicago.skgrogg.movies.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

class FavoritesClient {


    //uses dependency injection to instantiate a MoviesApi object
    fun favoritesApi(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.lightsailURL)
            .addConverterFactory(GsonConverterFactory.create())
    }


    private fun getOkHttpClient() = OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build()

    //todo set HttpLoggingInterceptor.Level.BODY to HttpLoggingInterceptor.Level.NONE for production release
    private fun getLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

}