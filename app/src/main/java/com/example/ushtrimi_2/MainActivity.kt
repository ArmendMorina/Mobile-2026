package com.example.ushtrimi_2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.reusablecoomposable.ReusableInputEmailInputField
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme
import com.example.ushtrimi_2.utils.validateUser

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                var screen by rememberSaveable { mutableStateOf("login") }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (screen) {
                        "login" -> LoginScreen(
                            innerPadding = innerPadding,
                            onSignUpClick = { screen = "signup" }
                        )

                        "signup" -> SignUpScreen(innerPadding)
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState called.....")
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

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy called")
    }
}


@Composable
fun LoginScreen(innerPadding: PaddingValues, onSignUpClick: () -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    var showErrorAlert by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_lock),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = "Welcome back", style = MaterialTheme.typography.headlineLarge
        )

        // Email
        ReusableInputEmailInputField(
            value = email, event = { enteredEmail ->
                email = enteredEmail
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), label = "Email"
        )

        // Password
        ReusableInputEmailInputField(
            value = password,
            event = { enteredPassword ->
                password = enteredPassword
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            label = "Password"
        )
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = {
                    if (validateUser(email = email, password = password)) {
                        Toast.makeText(
                            context, "Email and password from user are correct", Toast.LENGTH_LONG
                        ).show()
                    } else {
                        showErrorAlert = true
                    }
                },
                modifier = Modifier.weight(1f),
                enabled = email.isNotBlank() && password.isNotBlank()
            ) {
                Text(text = "Login")
            }

            OutlinedButton(
                onClick = onSignUpClick, modifier = Modifier.weight(1f)
            ) {
                Text(text = "Sign Up")
            }
        }

    }


    if (showErrorAlert) {
        AlertDialog(
            title = { Text(text = "Something went wrong") },
            text = { Text(text = "Please check your email or password.") },
            onDismissRequest = { showErrorAlert = false },
            confirmButton = {
                TextButton(onClick = { showErrorAlert = false }) {
                    Text(text = "Ok")
                }
            })
    }
}

@Composable
fun SignUpScreen(innerPadding: PaddingValues) {

    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var agreed by rememberSaveable { mutableStateOf(false) }
    var showPassword by rememberSaveable { mutableStateOf(false) }

    val passwordsMatch = password == confirmPassword
    val canSubmit = firstName.isNotBlank() && lastName.isNotBlank() &&
            email.isNotBlank() && password.length >= 6 &&
            confirmPassword.isNotBlank() && passwordsMatch && agreed

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = "Create account", style = MaterialTheme.typography.headlineLarge
        )

        ReusableInputEmailInputField(
            value = firstName, event = { enteredFirstName ->
                firstName = enteredFirstName
            }, label = "First Name"
        )

        ReusableInputEmailInputField(
            value = lastName, event = { enteredLastName ->
                lastName = enteredLastName
            }, label = "Last Name"
        )
        ReusableInputEmailInputField(
            value = email, event = { enteredEmail ->
                email = enteredEmail
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), label = "Email"
        )
        ReusableInputEmailInputField(
            value = password,
            event = { enterdPassword ->
                password = enterdPassword
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (showPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
            label = "Password"
        )
        Text(
            text = "Password must be at least 6 characters",
            style = MaterialTheme.typography.bodySmall,
            color = if (password.isNotEmpty() && password.length < 6) Color.Red
            else Color.Unspecified
        )

        ReusableInputEmailInputField(
            value = confirmPassword,
            event = { enterdConfirmPassword ->
                confirmPassword = enterdConfirmPassword
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            label = "Confirm password"
        )

        if (confirmPassword.isNotEmpty() && !passwordsMatch) {
            Text(
                text = "Passwords do not match",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = showPassword, onCheckedChange = { showPassword = it })
            Text(text = "Show password")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = agreed,
                onCheckedChange = { agreed = it })
            Text(text = "I agree to the Terms of Use")
        }

        Button(
            onClick = {
                Log.d("SignUp", "First name: $firstName, Last name: $lastName, Email: $email")
            },
            enabled = canSubmit,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Create account")
        }


    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Ushtrimi_2Theme {
        LoginScreen(PaddingValues(0.dp), onSignUpClick = {})
    }
}