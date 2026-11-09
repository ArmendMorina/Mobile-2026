package com.example.ushtrimi_2

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.reusableCoomposable.ReusableInputFiled

private const val TAG = "SignUp"

/** Stateful wrapper: each field keeps its own state; the stateless [SignUpScreen] only displays it. */
@Composable
fun SignUpRoute(innerPadding: PaddingValues, onBack: () -> Unit) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var termsAccepted by rememberSaveable { mutableStateOf(false) }

    SignUpScreen(
        innerPadding = innerPadding,
        firstName = firstName,
        lastName = lastName,
        email = email,
        password = password,
        confirmPassword = confirmPassword,
        termsAccepted = termsAccepted,
        onFirstNameChange = { firstName = it },
        onLastNameChange = { lastName = it },
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        onConfirmPasswordChange = { confirmPassword = it },
        onTermsChange = { termsAccepted = it },
        onCreateAccount = {
            Log.d(TAG, "First name: $firstName, Last name: $lastName, Email: $email")
        },
        onBack = onBack
    )
}

@Composable
fun SignUpScreen(
    innerPadding: PaddingValues,
    firstName: String,
    lastName: String,
    email: String,
    password: String,
    confirmPassword: String,
    termsAccepted: Boolean,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onTermsChange: (Boolean) -> Unit,
    onCreateAccount: () -> Unit,
    onBack: () -> Unit
) {
    val passwordsMatch = password == confirmPassword
    val canCreate = firstName.isNotBlank() &&
        lastName.isNotBlank() &&
        email.isNotBlank() &&
        password.isNotBlank() &&
        confirmPassword.isNotBlank() &&
        passwordsMatch &&
        termsAccepted

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create account",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        ReusableInputFiled(value = firstName, event = onFirstNameChange, label = "First name")
        ReusableInputFiled(value = lastName, event = onLastNameChange, label = "Last name")
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
            visualTransformation = PasswordVisualTransformation(),
            label = "Password"
        )
        ReusableInputFiled(
            value = confirmPassword,
            event = onConfirmPasswordChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            label = "Confirm password"
        )
        if (confirmPassword.isNotEmpty() && !passwordsMatch) {
            Text(
                text = "Passwords do not match",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Checkbox(checked = termsAccepted, onCheckedChange = onTermsChange)
            Text(text = "I agree to the Terms of Use")
        }

        Button(
            onClick = onCreateAccount,
            enabled = canCreate,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Create account")
        }

        TextButton(onClick = onBack) {
            Text(text = "Back to Login")
        }
    }
}
