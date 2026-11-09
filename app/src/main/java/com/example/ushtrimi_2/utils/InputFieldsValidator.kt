package com.example.ushtrimi_2.utils

import android.util.Patterns

fun validateUser(
    email : String,
    password : String,

) : Boolean {
    return email == "lorik.krasniqi@cacttus.edu" && password == "123456"
}

fun validateSignUp(
    email: String,
    password: String,
    confirmPassword: String,
    firstName: String,
    lastName: String
): String? {
    return when {
        firstName.isBlank() -> "First name is required"
        lastName.isBlank() -> "Last name is required"
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email address"
        password.length < 6 -> "Password must be at least 6 characters"
        password != confirmPassword -> "Passwords don't match"
        else -> null
    }
}