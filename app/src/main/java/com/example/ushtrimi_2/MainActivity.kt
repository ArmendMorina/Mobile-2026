package com.example.ushtrimi_2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.reusableCoomposable.ReusableInputFiled
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme
import com.example.ushtrimi_2.utlis.isSignupFormValid
import com.example.ushtrimi_2.utlis.validateUser

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var showSignup by rememberSaveable { mutableStateOf(false) }

                    if (showSignup) {
                        SignupScreen(
                            innerPadding = innerPadding,
                            onBackToLogin = { showSignup = false }
                        )
                    } else {
                        LoginScreen(
                            innerPadding = innerPadding,
                            onSignUp = { showSignup = true }
                        )
                    }

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
fun LoginScreen(
    innerPadding: PaddingValues,
    onSignUp: () -> Unit = {}
) {
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
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_lock),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )

            Text(
                text = "Welcome back",
                style = MaterialTheme.typography.headlineLarge
            )
            //email
            ReusableInputFiled(
                value = email,
                event = {enteredEmail->
                  email = enteredEmail
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = "Email"
            )

            //password
            ReusableInputFiled(
               value = password,
               event = {eneteredPassword->
                   password = eneteredPassword
               },
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
               visualTransformation = PasswordVisualTransformation(),
               label = "Password"
           )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {
                        if (validateUser(email = email, password = password)) {
                            Toast.makeText(
                                context,
                                "Email and password from user are correct",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            showErrorAlert = true
                        }
                    },
                    modifier = Modifier.weight(1f),
                    enabled = !email.isBlank() && !password.isBlank()
                ) {
                    Text(text = "Login")
                }

                Button(
                    onClick = onSignUp,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Sign Up")
                }
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

@Composable
fun SignupScreen(
    innerPadding: PaddingValues,
    onBackToLogin: () -> Unit
) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var termsAccepted by rememberSaveable { mutableStateOf(false) }
    var showPassword by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    val passwordsMismatch = confirmPassword.isNotBlank() && password != confirmPassword

    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        SignupForm(
            firstName = firstName,
            onFirstNameChange = { firstName = it },
            lastName = lastName,
            onLastNameChange = { lastName = it },
            email = email,
            onEmailChange = { email = it },
            password = password,
            onPasswordChange = { password = it },
            confirmPassword = confirmPassword,
            onConfirmPasswordChange = { confirmPassword = it },
            showPassword = showPassword,
            onShowPasswordChange = { showPassword = it },
            termsAccepted = termsAccepted,
            onTermsAcceptedChange = { termsAccepted = it },
            passwordsMismatch = passwordsMismatch,
            isCreateAccountEnabled = isSignupFormValid(
                firstName = firstName,
                lastName = lastName,
                email = email,
                password = password,
                confirmPassword = confirmPassword,
                termsAccepted = termsAccepted
            ),
            onCreateAccount = {
                Log.d("SignupScreen", "firstName=$firstName, lastName=$lastName, email=$email")
                Toast.makeText(context, "Account created", Toast.LENGTH_SHORT).show()
            },
            onBackToLogin = onBackToLogin
        )
    }
}

@Composable
fun SignupForm(
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChange: (String) -> Unit,
    showPassword: Boolean,
    onShowPasswordChange: (Boolean) -> Unit,
    termsAccepted: Boolean,
    onTermsAcceptedChange: (Boolean) -> Unit,
    passwordsMismatch: Boolean,
    isCreateAccountEnabled: Boolean,
    onCreateAccount: () -> Unit,
    onBackToLogin: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Create account",
            style = MaterialTheme.typography.headlineLarge
        )

        ReusableInputFiled(
            value = firstName,
            event = onFirstNameChange,
            label = "First name"
        )
        ReusableInputFiled(
            value = lastName,
            event = onLastNameChange,
            label = "Last name"
        )
        ReusableInputFiled(
            value = email,
            event = onEmailChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = "Email"
        )
        ReusableInputFiled(
            value = password,
            event = onPasswordChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            label = "Password"
        )
        Text(
            text = "Password must be at least 6 characters",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.fillMaxWidth()
        )
        ReusableInputFiled(
            value = confirmPassword,
            event = onConfirmPasswordChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            label = "Confirm password"
        )
        TextButton(onClick = { onShowPasswordChange(!showPassword) }) {
            Text(text = if (showPassword) "Hide password" else "Show password")
        }

        if (passwordsMismatch) {
            Text(
                text = "Passwords do not match",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = termsAccepted,
                onCheckedChange = onTermsAcceptedChange
            )
            Text(text = "I agree to the Terms of Use")
        }

        Button(
            onClick = onCreateAccount,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            enabled = isCreateAccountEnabled
        ) {
            Text(text = "Create account")
        }

        TextButton(onClick = onBackToLogin) {
            Text(text = "Back to Login")
        }
    }
}