package com.example.ushtrimi_2

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.reusableCoomposable.ReusableInputFiled
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme

private const val TAG = "SignUpScreen"

// Stateful composable - it holds the state and passes it down to SignUpForm
@Composable
fun SignUpScreen(innerPadding: PaddingValues, onBackToLogin: () -> Unit) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var agreeToTerms by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }

    SignUpForm(
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
        agreeToTerms = agreeToTerms,
        onAgreeToTermsChange = { agreeToTerms = it },
        showPassword = showPassword,
        onShowPasswordChange = { showPassword = it },
        onCreateAccountClick = {
            Log.d(TAG, "First name: ${firstName}")
            Log.d(TAG, "Last name: ${lastName}")
            Log.d(TAG, "Email: ${email}")
        },
        onBackToLogin = onBackToLogin
    )
}

// Stateless composable - it only shows the values it gets and sends events up
@Composable
fun SignUpForm(
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
    agreeToTerms: Boolean,
    onAgreeToTermsChange: (Boolean) -> Unit,
    showPassword: Boolean,
    onShowPasswordChange: (Boolean) -> Unit,
    onCreateAccountClick: () -> Unit,
    onBackToLogin: () -> Unit
) {
    val allFieldsFilled = firstName.isNotBlank() && lastName.isNotBlank() &&
            email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()
    val passwordsMatch = password == confirmPassword
    val isButtonEnabled = allFieldsFilled && passwordsMatch && agreeToTerms

    val passwordTransformation =
        if (showPassword) VisualTransformation.None else PasswordVisualTransformation()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Create account",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

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
            label = "Email address"
        )

        ReusableInputFiled(
            value = password,
            event = onPasswordChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = passwordTransformation,
            label = "Password"
        )

        // bonus: hint for short password
        if (password.isNotEmpty() && password.length < 6) {
            Text(
                text = "Password must be at least 6 characters",
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }

        ReusableInputFiled(
            value = confirmPassword,
            event = onConfirmPasswordChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = passwordTransformation,
            label = "Confirm password"
        )

        if (confirmPassword.isNotEmpty() && !passwordsMatch) {
            Text(
                text = "Passwords do not match",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // bonus: show password toggle
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = showPassword,
                onCheckedChange = onShowPasswordChange
            )
            Text(text = "Show password")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = agreeToTerms,
                onCheckedChange = onAgreeToTermsChange
            )
            Text(text = "I agree to the Terms of Use")
        }

        Button(
            onClick = onCreateAccountClick,
            enabled = isButtonEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Create account")
        }

        TextButton(onClick = onBackToLogin) {
            Text(text = "Already have an account? Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    Ushtrimi_2Theme {
        SignUpScreen(innerPadding = PaddingValues(0.dp), onBackToLogin = {})
    }
}
