package com.example.ushtrimi_2

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.reusableCoomposable.ReusableInputFiled

@Composable
fun SignUpScreen(innerPadding: PaddingValues, onLoginClick: () -> Unit) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var showPassword by rememberSaveable { mutableStateOf(false) }
    var agreed by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    SignUpContent(
        innerPadding = innerPadding,
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
        agreed = agreed,
        onAgreedChange = { agreed = it },
        onCreateAccountClick = {
            Toast.makeText(context, "Account created for $firstName", Toast.LENGTH_LONG).show()
        },
        onLoginClick = onLoginClick
    )
}

@Composable
fun SignUpContent(
    innerPadding: PaddingValues,
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
    agreed: Boolean,
    onAgreedChange: (Boolean) -> Unit,
    onCreateAccountClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val passwordsMatch = password == confirmPassword

    val buttonEnabled = firstName.isNotBlank() &&
            lastName.isNotBlank() &&
            email.contains("@") &&
            password.length >= 6 &&
            passwordsMatch &&
            agreed

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
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                label = "Password"
            )

            if (password.isNotEmpty() && password.length < 6) {
                Text(text = "Password must be at least 6 characters", color = Color.Red)
            }

            ReusableInputFiled(
                value = confirmPassword,
                event = onConfirmPasswordChange,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                label = "Confirm password"
            )

            if (confirmPassword.isNotEmpty() && !passwordsMatch) {
                Text(text = "Passwords do not match", color = Color.Red)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = showPassword, onCheckedChange = onShowPasswordChange)
                Text(text = "Show password")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = agreed, onCheckedChange = onAgreedChange)
                Text(text = "I agree to the Terms of Use")
            }

            Button(
                onClick = onCreateAccountClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                enabled = buttonEnabled
            ) {
                Text(text = "Create account")
            }

            TextButton(onClick = onLoginClick) {
                Text(text = "Already have an account? Login")
            }
        }
    }
}