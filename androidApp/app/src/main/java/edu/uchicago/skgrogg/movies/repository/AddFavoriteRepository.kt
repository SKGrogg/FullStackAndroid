package edu.uchicago.skgrogg.movies.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject


class AddFavoriteRepository  @Inject constructor() {

    suspend fun addMovie(title: String, year: Int, overview: String,
        posterPath: String, video: String, user: String){
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient().newBuilder()
                .build()
            var mediaType: MediaType = "application/json".toMediaTypeOrNull()!!
            var body: RequestBody = ("{\"title\":\"$title\", \"year\": $year, \"overview\": \"$overview\", " +
                    "\"posterPath\": \"$posterPath\", \"video\": \"$video\", \"user\": \"$user\"}")
                .toRequestBody(mediaType)
            val request: Request = Request.Builder()
                .url("https://quarkus-and-mongo.ssc846f0mfhpe.us-east-1.cs.amazonlightsail.com/movies")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build()
            val response: okhttp3.Response = client.newCall(request).execute()
            println(response)
        }

    }
}