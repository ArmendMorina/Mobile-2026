package com.example.ushtrimi_2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {

    var showSignUp by remember {
        mutableStateOf(false)
    }

    if (showSignUp) {

        SignUpScreen(
            onBackToLogin = {
                showSignUp = false
            }
        )

    } else {

        LoginScreen(
            onSignUpClick = {
                showSignUp = true
            }
        )
    }
}


@Composable
fun LoginScreen(
    onSignUpClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text("Email")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text("Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Button(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("Login")
            }

            Button(
                onClick = onSignUpClick,
                modifier = Modifier.weight(1f)
            ) {
                Text("Sign Up")
            }
        }
    }
}


@Composable
fun SignUpScreen(
    onBackToLogin: () -> Unit
) {

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var termsAccepted by remember {
        mutableStateOf(false)
    }

    var showPassword by remember {
        mutableStateOf(false)
    }


    val passwordsMatch =
        password == confirmPassword

    val allFieldsFilled =
        firstName.isNotBlank() &&
                lastName.isNotBlank() &&
                email.isNotBlank() &&
                password.isNotBlank() &&
                confirmPassword.isNotBlank()

    val passwordLongEnough =
        password.length >= 6

    val canCreateAccount =
        allFieldsFilled &&
                passwordsMatch &&
                passwordLongEnough &&
                termsAccepted


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Create account",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )


        OutlinedTextField(
            value = firstName,
            onValueChange = {
                firstName = it
            },
            label = {
                Text("First name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )


        OutlinedTextField(
            value = lastName,
            onValueChange = {
                lastName = it
            },
            label = {
                Text("Last name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )


        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Email address")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )


        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            visualTransformation =
                if (showPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )


        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
            },
            label = {
                Text("Confirm password")
            },
            visualTransformation =
                if (showPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
            modifier = Modifier.fillMaxWidth()
        )


        if (
            confirmPassword.isNotEmpty() &&
            !passwordsMatch
        ) {

            Text(
                text = "Passwords do not match",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
        }


        if (
            password.isNotEmpty() &&
            password.length < 6
        ) {

            Text(
                text = "Password must be at least 6 characters",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
        }


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Checkbox(
                checked = showPassword,
                onCheckedChange = {
                    showPassword = it
                }
            )

            Text(
                text = "Show password"
            )
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Checkbox(
                checked = termsAccepted,
                onCheckedChange = {
                    termsAccepted = it
                }
            )

            Text(
                text = "I agree to the Terms of Use"
            )
        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        Button(
            onClick = {

                Log.d(
                    "SignUp",
                    "First name: $firstName"
                )

                Log.d(
                    "SignUp",
                    "Last name: $lastName"
                )

                Log.d(
                    "SignUp",
                    "Email: $email"
                )
            },
            enabled = canCreateAccount,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Create account")
        }


        Spacer(
            modifier = Modifier.height(10.dp)
        )


        Button(
            onClick = onBackToLogin,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Back to Login")
        }
    }
}