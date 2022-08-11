package edu.uchicago.skgrogg.movies.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uchicago.skgrogg.favs.data.repository.FavoritesRepository
import edu.uchicago.skgrogg.favs.presentation.search.SearchStateMovie
import edu.uchicago.skgrogg.movies.common.Constants
import edu.uchicago.skgrogg.movies.models.Favorite
import edu.uchicago.skgrogg.movies.repository.AddFavoriteRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import edu.uchicago.skgrogg.movies.models.Result
import edu.uchicago.skgrogg.movies.screens.favorites.paging.SearchStateFavorite

class FavoriteViewModel: ViewModel() {

    val addFavRepo = AddFavoriteRepository()

    val favoritesRepository = FavoritesRepository();

    val mFavorites = MutableLiveData<List<Favorite>?>()

    private var _titleText = mutableStateOf<String>("")
    val titleText: State<String> = _titleText

    private var _yearInt = mutableStateOf<Int>(0)
    val yearInt: State<Int> = _yearInt

    private var _overviewText = mutableStateOf<String>("")
    val overviewText: State<String> = _overviewText

    private var _posterPathText = mutableStateOf<String>("")
    val posterPathText: State<String> = _posterPathText

    private var _videoText = mutableStateOf<String>("")
    val videoText: State<String> = _videoText

    private var _userText = mutableStateOf<String>("")
    val userText: State<String> = _userText


    var _favorite = mutableStateOf<Favorite>(Constants.fakeFavorite)
    val favorite: State<Favorite> = _favorite

    val _searchState = mutableStateOf(SearchStateFavorite())
    var searchState: State<SearchStateFavorite> = _searchState

    init {
        //getFavorites()
    }

    fun setTitleText(title: String) {
        _titleText.value = title
    }

    fun setYearInt(year: Int) {
        _yearInt.value = year
    }

    fun setOverviewText(overview: String) {
        _overviewText.value = overview
    }

    fun setPosterPathText(posterPath: String) {
        _posterPathText.value = posterPath
    }

    fun setVideoText(video: String) {
        _videoText.value = video
    }

    fun setUserText(user: String) {
        _userText.value = user
    }

    //////////////////////////////////////////
    // FUNCTIONS
    //////////////////////////////////////////
    fun setFavorite(favorite: Favorite) {
        _favorite.value = favorite
    }

    fun getList(): MutableLiveData<List<Favorite>?>{
        return mFavorites
    }


    fun getFavorites() {
        favoritesRepository.getFavorites().enqueue(object: Callback<List<Favorite>> {
            override fun onResponse(
                call: Call<List<Favorite>>,
                response: Response<List<Favorite>>
            ) {
                val favorites = response.body()
                favorites.let{
                    mFavorites.value = favorites
                }
            }

            override fun onFailure(call: Call<List<Favorite>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun onSubmit(movie: Result, year: String, user: String) {
        viewModelScope.launch {
            addFavRepo.addMovie(movie.title, year.toInt(), movie.overview, movie.posterPath,
                                    movie.posterPath, user)
        }
    }
}