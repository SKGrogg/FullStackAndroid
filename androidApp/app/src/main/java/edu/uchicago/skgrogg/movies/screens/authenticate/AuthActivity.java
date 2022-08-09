package edu.uchicago.skgrogg.movies.screens.authenticate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.SignInUIOptions;
import com.amazonaws.mobile.client.UserStateDetails;
import com.google.gson.Gson;

import edu.uchicago.skgrogg.movies.MainActivity;
import edu.uchicago.skgrogg.movies.cache.Cache;
import edu.uchicago.skgrogg.movies.models.Token;
import edu.uchicago.skgrogg.movies.common.utils.JWTUtils;
import edu.uchicago.skgrogg.movies.R;

public class AuthActivity extends AppCompatActivity {

    //used as the default email in the event authentication is disabled
    public static final String DEFAULT_COM = "default@default.com";
    private final String TAG = AuthActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if use_auth is set to false, then short circuit
        String strUseAuth =  getResources().getString(R.string.use_auth);
        if (!Boolean.parseBoolean(strUseAuth)){
            Cache.getInstance().setUserEmail(DEFAULT_COM);
            Intent intent = new Intent(AuthActivity.this, MainActivity.class);
            startActivity(intent);

        } else {
            AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
                @Override
                public void onResult(UserStateDetails userStateDetails) {
                    Log.d(TAG, userStateDetails.getUserState().toString());
                    switch (userStateDetails.getUserState()){
                        case SIGNED_IN:
                            String strCodedToken =  userStateDetails.getDetails().get("token");
                            setEmail(strCodedToken);
                            Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                            startActivity(intent);
                            break;
                        case SIGNED_OUT:
                            showSignIn();
                            break;
                        default:
                            AWSMobileClient.getInstance().signOut();
                            showSignIn();
                            break;

                    }
                }
                @Override
                public void onError(Exception e){
                    Log.e(TAG, e.toString());
                }
            });
        }


    }


    private void setEmail(String codedToken) {
        String decoded = "";
        try {
            decoded =  JWTUtils.decodedBody(codedToken);
            Gson gson = new Gson();
            Token token = gson.fromJson(decoded, Token.class);
            Cache.getInstance().setUserEmail(token.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSignIn() {
        try {
            AWSMobileClient.getInstance().showSignIn(this,
                    SignInUIOptions.builder()
                            .nextActivity(MainActivity.class)
                            .build(),
            new Callback<UserStateDetails>() {
                @Override
                public void onResult(UserStateDetails result) {
                    Log.d(TAG, "showSignIn() onResult() result: userState: " + result.getUserState());
                    switch (result.getUserState()){
                        case SIGNED_IN:
                            Log.d(TAG, "showSignIn() callback: SIGNED_IN logged in!");
                            setEmail(result.getDetails().get("token"));
                            break;
                        case SIGNED_OUT:
                            Log.d(TAG, "showSignIn() callback onResult: SIGNED_OUT ");
                            break;
                        default:
                            Log.d(TAG, "showSignIn() callback onResult: default; Should not be possible.");
                            break;
                    }
                }

                @Override
                public void onError(Exception e) {
                    Log.e(TAG, "showSignIn().onError: ", e);
                }
            }

            );


        } catch (Exception e) {
            Log.e("AuthActivity", e.toString());
        }
    }
}