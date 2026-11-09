package com.example.ushtrimi_2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.reusableCoomposable.ConfirmPasswordField
import com.example.ushtrimi_2.reusableCoomposable.CreateAccountButton
import com.example.ushtrimi_2.reusableCoomposable.EmailField
import com.example.ushtrimi_2.reusableCoomposable.FirstNameField
import com.example.ushtrimi_2.reusableCoomposable.LastNameField
import com.example.ushtrimi_2.reusableCoomposable.PasswordField
import com.example.ushtrimi_2.reusableCoomposable.ShowPasswordCheckbox
import com.example.ushtrimi_2.reusableCoomposable.SignUpTitle
import com.example.ushtrimi_2.reusableCoomposable.TermsCheckbox
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme
import com.example.ushtrimi_2.utlis.canCreateAccount

class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(innerPadding)
                }
            }
        }
    }
}

/**
 * The state lives HERE (state hoisting).
 * Every field below is a stateless function that gets its value
 * and a lambda to change it.
 */
@Composable
fun SignUpScreen(innerPadding: PaddingValues) {
    // Each field keeps its own state with remember
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var agreeToTerms by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        SignUpTitle()

        FirstNameField(
            firstName = firstName,
            onFirstNameChange = { enteredFirstName -> firstName = enteredFirstName }
        )

        LastNameField(
            lastName = lastName,
            onLastNameChange = { enteredLastName -> lastName = enteredLastName }
        )

        EmailField(
            email = email,
            onEmailChange = { enteredEmail -> email = enteredEmail }
        )

        PasswordField(
            password = password,
            onPasswordChange = { enteredPassword -> password = enteredPassword },
            showPassword = showPassword
        )

        ConfirmPasswordField(
            password = password,
            confirmPassword = confirmPassword,
            onConfirmPasswordChange = { enteredPassword -> confirmPassword = enteredPassword },
            showPassword = showPassword
        )

        ShowPasswordCheckbox(
            showPassword = showPassword,
            onShowPasswordChange = { checked -> showPassword = checked }
        )

        TermsCheckbox(
            agreeToTerms = agreeToTerms,
            onAgreeToTermsChange = { checked -> agreeToTerms = checked }
        )

        CreateAccountButton(
            enabled = canCreateAccount(
                firstName = firstName,
                lastName = lastName,
                email = email,
                password = password,
                confirmPassword = confirmPassword,
                agreeToTerms = agreeToTerms
            ),
            onClick = {
                Log.d("SignUpScreen", "First name: $firstName")
                Log.d("SignUpScreen", "Last name: $lastName")
                Log.d("SignUpScreen", "Email: $email")
            }
        )
    }
}
