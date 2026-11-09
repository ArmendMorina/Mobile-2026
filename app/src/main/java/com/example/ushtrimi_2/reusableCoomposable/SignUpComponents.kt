package com.example.ushtrimi_2.reusableCoomposable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.utlis.MIN_PASSWORD_LENGTH
import com.example.ushtrimi_2.utlis.isPasswordTooShort
import com.example.ushtrimi_2.utlis.passwordsDoNotMatch

/*
 * All functions here are STATELESS (state hoisting):
 *  - they receive the current value from the parent  (state goes down)
 *  - they send changes back with a lambda            (events go up)
 * The state itself lives in SignUpScreen.
 */

@Composable
fun SignUpTitle() {
    Text(
        text = "Create account",
        style = MaterialTheme.typography.headlineLarge
    )
}

@Composable
fun FirstNameField(firstName: String, onFirstNameChange: (String) -> Unit) {
    ReusableInputFiled(
        value = firstName,
        event = onFirstNameChange,
        label = "First name"
    )
}

@Composable
fun LastNameField(lastName: String, onLastNameChange: (String) -> Unit) {
    ReusableInputFiled(
        value = lastName,
        event = onLastNameChange,
        label = "Last name"
    )
}

@Composable
fun EmailField(email: String, onEmailChange: (String) -> Unit) {
    ReusableInputFiled(
        value = email,
        event = onEmailChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = "Email address"
    )
}

/** Password field + bonus hint "Password must be at least 6 characters". */
@Composable
fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
    showPassword: Boolean
) {
    ReusableInputFiled(
        value = password,
        event = onPasswordChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = passwordTransformation(showPassword),
        label = "Password"
    )

    if (isPasswordTooShort(password)) {
        Text(
            text = "Password must be at least $MIN_PASSWORD_LENGTH characters",
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

/** Confirm password field + red error when it does not match the password. */
@Composable
fun ConfirmPasswordField(
    password: String,
    confirmPassword: String,
    onConfirmPasswordChange: (String) -> Unit,
    showPassword: Boolean
) {
    ReusableInputFiled(
        value = confirmPassword,
        event = onConfirmPasswordChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = passwordTransformation(showPassword),
        label = "Confirm password"
    )

    if (passwordsDoNotMatch(password, confirmPassword)) {
        Text(
            text = "Passwords do not match",
            color = Color.Red,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

/** Bonus: "Show password" toggle. */
@Composable
fun ShowPasswordCheckbox(showPassword: Boolean, onShowPasswordChange: (Boolean) -> Unit) {
    LabeledCheckbox(
        checked = showPassword,
        onCheckedChange = onShowPasswordChange,
        label = "Show password"
    )
}

@Composable
fun TermsCheckbox(agreeToTerms: Boolean, onAgreeToTermsChange: (Boolean) -> Unit) {
    LabeledCheckbox(
        checked = agreeToTerms,
        onCheckedChange = onAgreeToTermsChange,
        label = "I agree to the Terms of Use"
    )
}

@Composable
fun CreateAccountButton(enabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        Text(text = "Create account")
    }
}

/** A Checkbox with a text label next to it. */
@Composable
fun LabeledCheckbox(checked: Boolean, onCheckedChange: (Boolean) -> Unit, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(text = label)
    }
}

/** Hidden text (dots) or visible text, depending on "Show password". */
fun passwordTransformation(showPassword: Boolean): VisualTransformation {
    return if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
}
