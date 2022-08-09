package edu.uchicago.skgrogg.favs.data.repository


import edu.uchicago.skgrogg.movies.common.Constants
import edu.uchicago.skgrogg.movies.models.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

//simple movies repo
class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi) {

    //this must be called on a background thread b/c it is long-running
    //here, I pass in the parameters I need, which then re-pass to the instantated interface
    suspend fun getMovies(
        page: Int,
        primary_release_year: String,
    ): Response<MoviesResponse> {
        return withContext(Dispatchers.IO) {
            moviesApi.getMovies(
                apiKey = Constants.apiKey,
                sortBy = Constants.sortBy,
                page = page,
                primary_release_year = primary_release_year
            )
        }
    }
}



