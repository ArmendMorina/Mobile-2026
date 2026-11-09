package com.example.ushtrimi_2.utlis

fun isSignupFormValid(
    firstName: String,
    lastName: String,
    email: String,
    password: String,
    confirmPassword: String,
    termsAccepted: Boolean
): Boolean {
    return firstName.isNotBlank() &&
        lastName.isNotBlank() &&
        email.isNotBlank() &&
        password.length >= 6 &&
        password == confirmPassword &&
        termsAccepted
}
