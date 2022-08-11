package edu.uchicago.skgrogg.movies.screens.favorites.paging

import androidx.paging.PagingData
import edu.uchicago.skgrogg.movies.models.Favorite

import kotlinx.coroutines.flow.Flow

data class SearchStateFavorite(
    val searchOperationFavorite: SearchOperationFavorite = SearchOperationFavorite.INITIAL,
    val data: Flow<PagingData<Favorite>>? = null
)

enum class SearchOperationFavorite { LOADING, INITIAL, DONE }