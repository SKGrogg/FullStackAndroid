package edu.uchicago.skgrogg.favs.presentation.search

import androidx.paging.PagingData
import edu.uchicago.skgrogg.movies.models.Result

import kotlinx.coroutines.flow.Flow

data class SearchStateMovie(
    val searchOperationMovie: SearchOperationMovie = SearchOperationMovie.INITIAL,
    val data: Flow<PagingData<Result>>? = null
)

enum class SearchOperationMovie { LOADING, INITIAL, DONE }