package edu.uchicago.skgrogg.movies.screens.authenticate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.mobile.client.*
import com.google.gson.Gson
import edu.uchicago.skgrogg.movies.MainActivity
import edu.uchicago.skgrogg.movies.cache.Cache
import edu.uchicago.skgrogg.movies.common.Constants
import edu.uchicago.skgrogg.movies.common.utils.JWTUtils
import edu.uchicago.skgrogg.movies.models.Token
import java.lang.Boolean
import kotlin.Exception
import kotlin.String

class AuthActivity: AppCompatActivity() {

    //used as the default email in the event authentication is disabled
    val DEFAULT_COM = "default@default.com"
    val TAG = AuthActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //if use_auth is set to false, then short circuit
        val strUseAuth: String = "false"
        if (!Boolean.parseBoolean(strUseAuth)) {
            Log.d("Cognito Effort", DEFAULT_COM)
            Cache.getInstance().userEmail = DEFAULT_COM
            val intent = Intent(this@AuthActivity, MainActivity::class.java)
            startActivity(intent)
        } else {
            AWSMobileClient.getInstance()
                .initialize(getApplicationContext(), object : Callback<UserStateDetails> {
                    override fun onResult(userStateDetails: UserStateDetails) {
                        Log.d(TAG, userStateDetails.userState.toString())
                        when (userStateDetails.userState) {
                            UserState.SIGNED_IN -> {
                                val strCodedToken = userStateDetails.details["token"]
                                setEmail(strCodedToken)
                                val intent = Intent(this@AuthActivity, MainActivity::class.java)
                                startActivity(intent)
                            }
                            UserState.SIGNED_OUT -> showSignIn()
                            else -> {
                                AWSMobileClient.getInstance().signOut()
                                showSignIn()
                            }
                        }
                    }

                    override fun onError(e: Exception) {
                        Log.e(TAG, e.toString())
                    }
                })
        }
    }


    open fun setEmail(codedToken: String?) {
        var decoded: String? = ""
        try {
            decoded = JWTUtils.decodedBody(codedToken)
            val gson = Gson()
            val token = gson.fromJson(
                decoded,
                Token::class.java
            )
            Cache.getInstance().userEmail = token.email
            Constants.userEmial = token.email
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    open fun showSignIn() {
        try {
            AWSMobileClient.getInstance().showSignIn(this,
                SignInUIOptions.builder()
                    .nextActivity(MainActivity::class.java)
                    .build(),
                object : Callback<UserStateDetails> {
                    override fun onResult(result: UserStateDetails) {
                        Log.d(TAG, "showSignIn() onResult() result: userState: " + result.userState)
                        when (result.userState) {
                            UserState.SIGNED_IN -> {
                                Log.d(TAG, "showSignIn() callback: SIGNED_IN logged in!")
                                setEmail(result.details["token"])
                            }
                            UserState.SIGNED_OUT -> Log.d(
                                TAG,
                                "showSignIn() callback onResult: SIGNED_OUT "
                            )
                            else -> Log.d(
                                TAG,
                                "showSignIn() callback onResult: default; Should not be possible."
                            )
                        }
                    }

                    override fun onError(e: Exception) {
                        Log.e(TAG, "showSignIn().onError: ", e)
                    }
                }
            )
        } catch (e: Exception) {
            Log.e("AuthActivity", e.toString())
        }
    }
}
