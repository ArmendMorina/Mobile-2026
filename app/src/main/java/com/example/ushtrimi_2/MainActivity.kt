package com.example.ushtrimi_2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ushtrimi_2.home.contacts.ContactsActivity
import com.example.ushtrimi_2.reusableCoomposable.ReusableInputFiled
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme
import com.example.ushtrimi_2.utlis.validateUser
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(innerPadding )

                }
            }
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState called.....")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy called")

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "OnResume called")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnPause called")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop called")
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ushtrimi_2Theme {
        Greeting("Android")
    }
}

@Composable
fun LoginScreen(innerPadding: PaddingValues) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    var showErrorAlert by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.default_padding))
        ) {
            Image(
                painter = painterResource(R.drawable.ic_lock),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )

            Text(
                text = stringResource(R.string.welcome_back),
                style = MaterialTheme.typography.headlineLarge
            )
            //email
            ReusableInputFiled(
                value = email,
                event = {enteredEmail->
                  email = enteredEmail
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = stringResource(R.string.email)
            )

            //password
            ReusableInputFiled(
               value = password,
               event = {eneteredPassword->
                   password = eneteredPassword
               },
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
               visualTransformation = PasswordVisualTransformation(),
               label = stringResource(R.string.password)
           )

            Button(
                onClick = {
                    if (validateUser(email = email, password = password)){
                        Toast.makeText(context,"Email and password from user are correct",
                            Toast.LENGTH_LONG).show();

                        context.startActivity(
                            Intent(
                                context,
                                ContactsActivity::class.java
                            )
                        )
                    }else{
                       showErrorAlert = true
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                enabled = !email.isBlank() && !password.isBlank()
            ) {
                Text(text = stringResource(R.string.login))
            }
        }
    }

    if (showErrorAlert){
        AlertDialog(
            title = {Text(text = "Something went wrong")},
            text = {Text(text = "Please check your email  or password ")},
            onDismissRequest = {
                showErrorAlert = false
            },
            confirmButton ={
                TextButton(onClick = {showErrorAlert = false}) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                TextButton(onClick = {showErrorAlert = false}) {
                    Text(text = "Cancel")
                }
            }
        )
    }





}