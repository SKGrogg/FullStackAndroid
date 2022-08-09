package edu.uchicago.skgrogg.movies

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MoviesApplication : Application(){
    private var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}