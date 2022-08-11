package edu.uchicago.skgrogg.movies.screens.favorites.paging

import android.app.Application
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import edu.uchicago.skgrogg.favs.data.repository.FavoritesRepository
import edu.uchicago.skgrogg.movies.models.Result
import edu.uchicago.skgrogg.favs.data.repository.MoviesRepository
import edu.uchicago.skgrogg.favs.models.PaginateMovies
import edu.uchicago.skgrogg.movies.models.Favorite
import edu.uchicago.skgrogg.movies.viewmodels.FavoriteViewModel
import edu.uchicago.skgrogg.movies.viewmodels.MovieViewModel

import javax.inject.Inject

class FavoriteSource @Inject constructor(
    private val favoritesRepository: FavoritesRepository,
    private val favoritesViewModel: FavoriteViewModel,
    private val paginateData: PaginateMovies,
    private val application: Application
) :
    PagingSource<Int, Favorite>() {
    override fun getRefreshKey(state: PagingState<Int, Favorite>): Int? {
        Log.d("Favorites Loading", "Inside Source.getRefreshKey")
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Favorite> {
        return try {
            Log.d("Favorites Loading", "Inside Source.load")
            val prev = params.key ?: 1

            val response = favoritesViewModel.favoritesRepository.getFavorites()

            if (response.isExecuted) {
                favoritesViewModel.getFavorites();
                val body = favoritesViewModel.getList()?.value
                val totPages = 1
                LoadResult.Page(
                    data = body!!,
                    prevKey = if (prev == 1) null else prev - 1,
                    nextKey = if (prev >= totPages) null else prev + 1
                )
            } else {
                 LoadResult.Error(Exception("Something went amiss."))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true

}