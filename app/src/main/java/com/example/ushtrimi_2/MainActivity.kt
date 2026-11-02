package com.example.ushtrimi_2

import android.os.Bundle
import android.util.Log
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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(innerPadding)

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
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_lock),
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                colorFilter = ColorFilter.tint(Color.Blue)
            )

            Text(
                text = "Welcome back",
                style = MaterialTheme.typography.headlineLarge
            )

           var email = ""

            //email
            OutlinedTextField(
                value = email,
                label = { Text(text = "Email") },
                onValueChange = {
                    email = it
                },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()

            )

            //password
            OutlinedTextField(
                value = "",
                label = { Text(text = "Password") },
                onValueChange = {

                },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()

            )

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
                    .padding(32.dp),
                enabled = false
            ) {
                Text(text = "Login")
            }
        }


    }

}