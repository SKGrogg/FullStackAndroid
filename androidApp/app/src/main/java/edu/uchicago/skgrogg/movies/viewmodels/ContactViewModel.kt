package edu.uchicago.skgrogg.movies.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.uchicago.skgrogg.favs.data.repository.MoviesRepository
import edu.uchicago.skgrogg.movies.repository.EmailRepository
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject


@HiltViewModel
class ContactViewModel @Inject constructor(
    private val application: Application
) :
    ViewModel() {

    val emailRepo = EmailRepository()
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
        _subjectText.value = subject
    }

    fun setBodyText(body: String) {
        _bodyText.value = body
    }

    fun setEmailText(email: String) {
        _emailText.value = email
    }

    /*
   fun onContact() {
        if ((_subjectText.value.length == 0) || (_bodyText.value.length == 0) || (_emailText.value.length == 0)){
            Log.d("Contact Error: ", "'Subject': " + _subjectText.value + ", 'Body':" + _bodyText.value + ", 'Email':" + _emailText.value)
            Toast.makeText(application, "Please file out all field!", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(application, _subjectText.value + ", " + _bodyText.value + ", " + _emailText.value, Toast.LENGTH_LONG).show()
            sendEmail(_subjectText.value, _bodyText.value, _emailText.value)
        }
    }
    fun sendEmail(subject: String, body: String, email: String){
         val json = JsonObject()
         json.addProperty("subject", subject)
         json.addProperty("body", body)
         json.addProperty("email", email)
         val client = OkHttpClient().newBuilder()
             .build()
         val mediaType: MediaType? = "application/json".toMediaTypeOrNull()
         val body: RequestBody = json.toString().toRequestBody(mediaType)
         val request: Request = Request.Builder()
             .url("https://7fof14yl3j.execute-api.us-east-1.amazonaws.com/Prod/mail")
             .method("POST", body)
             .addHeader("Content-Type", "application/json")
             .build()
         val response: Response = client.newCall(request).execute()
         Log.d("Email Attempt", response.toString())
     }

     */

    fun onSubmit() {
        if ((_subjectText.value.length == 0) || (_bodyText.value.length == 0) || (_emailText.value.length == 0)){
            Toast.makeText(application, "Please file out all field!", Toast.LENGTH_LONG).show()
        }else{
        }
        viewModelScope.launch {
            emailRepo.Emailer(_subjectText.value, _bodyText.value, _emailText.value)
        }
        _subjectText.value = ""
        _bodyText.value = ""
        _emailText.value = ""
    }

}


