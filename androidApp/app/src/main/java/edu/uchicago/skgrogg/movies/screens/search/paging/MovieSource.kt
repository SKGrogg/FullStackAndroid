package edu.uchicago.skgrogg.favs.presentation.screens.search.paging

import android.app.Application
import androidx.paging.PagingSource
import androidx.paging.PagingState
import edu.uchicago.skgrogg.movies.models.Result
import edu.uchicago.skgrogg.favs.data.repository.MoviesRepository
import edu.uchicago.skgrogg.favs.models.PaginateMovies

import javax.inject.Inject

class MovieSource @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val paginateData: PaginateMovies,
    private val application: Application
) :
    PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val prev = params.key ?: 1

            val response = moviesRepository.getMovies(
                page = prev,
                primary_release_year = paginateData.primary_release_year
            )

            if (response.isSuccessful) {
                val body = response.body()?.results
                val totPages = response.body()?.totalPages!!
                LoadResult.Page(
                    data = body!!,
                    prevKey = if (prev == 1) null else prev - 1,
                    nextKey = if (prev >= totPages) null else prev + 1
                )
            } else {
                 LoadResult.Error(Exception(response.message()))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true

}