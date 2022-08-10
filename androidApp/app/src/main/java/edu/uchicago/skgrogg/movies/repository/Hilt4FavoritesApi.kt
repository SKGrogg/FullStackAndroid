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

@Module
@InstallIn(SingletonComponent::class)
class Hilt4FavoritesApi {


    //uses dependency injection to instantiate a MoviesApi object
    @Provides
    @Singleton
    fun favoritesApi(): FavoritesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.lightsailURL)
            //add a client allows us to intercept the network traffic
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FavoritesApi::class.java)
    }


    private fun getOkHttpClient() = OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build()

    //todo set HttpLoggingInterceptor.Level.BODY to HttpLoggingInterceptor.Level.NONE for production release
    private fun getLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

}