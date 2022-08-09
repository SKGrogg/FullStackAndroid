package edu.uchicago.skgrogg.movies.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.uchicago.skgrogg.movies.common.Constants
import edu.uchicago.skgrogg.movies.models.Result
import edu.uchicago.skgrogg.favs.data.repository.MoviesRepository
import edu.uchicago.skgrogg.favs.models.PaginateMovies
import edu.uchicago.skgrogg.favs.presentation.screens.search.paging.MovieSource
import edu.uchicago.skgrogg.favs.presentation.search.SearchOperationMovie

import edu.uchicago.skgrogg.favs.presentation.search.SearchStateMovie
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val application: Application
) :
    ViewModel() {

    //////////////////////////////////////////
    // MUTABLE-STATES AND OBSERVABLE STATES
    //////////////////////////////////////////
    private var _queryText = mutableStateOf<String>("")
    val queryText: State<String> = _queryText


    private var _movie = mutableStateOf<Result>(Constants.fakeMovie)
    val movie: State<Result> = _movie

    private val _searchState = mutableStateOf(SearchStateMovie())
    val searchState: State<SearchStateMovie> = _searchState


    //////////////////////////////////////////
    // FUNCTIONS
    //////////////////////////////////////////
    fun setMovie(movie: Result) {
        _movie.value = movie
    }

    fun setQueryText(query: String) {
        _queryText.value = query
    }



    fun onSearch() {
        if ((_queryText.value.length != 4) || !((_queryText.value.toInt() >= 1955) && (_queryText.value.toInt()) <= 2022)){
            Log.d("query year: ", "" + _queryText.value.toInt())
            Toast.makeText(application, "ENTER A VALID YEAR", Toast.LENGTH_LONG).show()
        }else {
            _searchState.value = SearchStateMovie(searchOperationMovie = SearchOperationMovie.LOADING)
            viewModelScope.launch {
                _searchState.value = SearchStateMovie(
                    data = Pager(
                        config = PagingConfig(pageSize = 10, prefetchDistance = 5),
                        pagingSourceFactory = {
                            MovieSource(
                                moviesRepository = moviesRepository,
                                paginateData = PaginateMovies(
                                    primary_release_year = _queryText.value,
                                ),
                                application
                            )
                        }
                    ).flow.cachedIn(viewModelScope),
                    searchOperationMovie = SearchOperationMovie.DONE
                )
            }
        }
    }


}


