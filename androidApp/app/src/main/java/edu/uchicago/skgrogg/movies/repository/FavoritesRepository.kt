package edu.uchicago.skgrogg.favs.data.repository


import edu.uchicago.skgrogg.movies.common.Constants
import edu.uchicago.skgrogg.movies.models.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

//simple movies repo
class FavoritesRepository @Inject constructor(private val favoritesApi: FavoritesApi) {

    //this must be called on a background thread b/c it is long-running
    //here, I pass in the parameters I need, which then re-pass to the instantated interface
    suspend fun getFavorites(
        user: String
    ): Response<ResponseBody> {
        return withContext(Dispatchers.IO) {
            favoritesApi.getFavorites(
                user = user
            )
        }
    }
}



