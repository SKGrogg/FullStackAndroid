package edu.uchicago.skgrogg.favs.presentation.screens.contact

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.JsonObject
import edu.uchicago.skgrogg.favs.screens.CustomEmailTextField
import edu.uchicago.skgrogg.movies.MainActivity
import edu.uchicago.skgrogg.movies.R
import edu.uchicago.skgrogg.movies.navagation.Screen
import edu.uchicago.skgrogg.movies.viewmodels.ContactViewModel
import edu.uchicago.skgrogg.movies.widgets.BottomNavigationBar
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import javax.security.auth.Subject


@Composable
fun ContactScreen(
    contactViewModel: ContactViewModel,
    navController: NavController,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
)
{
    val subjectText = contactViewModel.subjectText.value
    val bodyText = contactViewModel.bodyText.value
    val emailText = contactViewModel.emailText.value

    val scope = rememberCoroutineScope()


    Scaffold(scaffoldState = scaffoldState,
        bottomBar = { BottomNavigationBar(navController) },
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 1.dp,

                ) {
                Text(
                    text = "Contact Us",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )

            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            CustomEmailTextField(
                title = "Subject",
                placeHolder = "E.g. App Issues",
                textState = subjectText,
                onTextChange = contactViewModel::setSubjectText,
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomEmailTextField(
                title = "Body",
                placeHolder = "Type a Message for the Development Team",
                textState = bodyText,
                onTextChange = contactViewModel::setBodyText,
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomEmailTextField(
                title = "Reply Email",
                placeHolder = "teddyfitz@hotmail.web",
                textState = emailText,
                onTextChange = contactViewModel::setEmailText,
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(10.dp))
            FloatingActionButton(
                onClick = contactViewModel::onSubmit,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Row(Modifier.padding(start = 12.dp, end = 12.dp)) {
                    AnimatedVisibility(true,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(modifier = Modifier.padding(start = 12.dp), text = "Submit")
                    }
                }
            }
            Spacer(Modifier.requiredHeight(20.dp))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
   // ContactScreen()
}