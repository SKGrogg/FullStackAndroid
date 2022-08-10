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
class ContactViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val application: Application
) :
    ViewModel() {

    //////////////////////////////////////////
    // MUTABLE-STATES AND OBSERVABLE STATES
    //////////////////////////////////////////
    private var _subjectText = mutableStateOf<String>("")
    val subjectText: State<String> = _subjectText

    private var _bodyText = mutableStateOf<String>("")
    val bodyText: State<String> = _bodyText

    private var _emailText = mutableStateOf<String>("")
    val emailText: State<String> = _emailText



    //////////////////////////////////////////
    // FUNCTIONS
    //////////////////////////////////////////


    fun setSubjectText(subject: String) {
        Log.i("Subject Set: ", subject)
        _subjectText.value = subject
    }

    fun setBodyText(body: String) {
        _bodyText.value = body
    }

    fun setEmailText(email: String) {
        _emailText.value = email
    }



    fun onContact() {
        if ((_subjectText.value.length == 0) || (_bodyText.value.length == 0) || (_emailText.value.length == 0)){
            Log.d("Contact Error: ", "'Subject': " + _subjectText.value + ", 'Body':" + _bodyText.value + ", 'Email':" + _emailText.value)
            Toast.makeText(application, "Please file out all field!", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(application, _subjectText.value + ", " + _bodyText.value + ", " + _emailText.value, Toast.LENGTH_LONG).show()
            }
    }

}


