package com.example.ushtrimi_2.utlis

const val MIN_PASSWORD_LENGTH = 6

fun validateUser(
    email: String,
    password: String
): Boolean {
    return email == "armend.morina@cacttus.edu" && password == "123456"

}

/** True when every Sign Up field has text in it. */
fun areAllFieldsFilled(
    firstName: String,
    lastName: String,
    email: String,
    password: String,
    confirmPassword: String
): Boolean {
    return firstName.isNotBlank() &&
            lastName.isNotBlank() &&
            email.isNotBlank() &&
            password.isNotBlank() &&
            confirmPassword.isNotBlank()
}

/** True when password and confirm password are equal. */
fun passwordsMatch(password: String, confirmPassword: String): Boolean {
    return password == confirmPassword
}

/** True only after the user typed in "Confirm password" and it is different. */
fun passwordsDoNotMatch(password: String, confirmPassword: String): Boolean {
    return confirmPassword.isNotEmpty() && !passwordsMatch(password, confirmPassword)
}

/** True when a password was typed but it is shorter than 6 characters. */
fun isPasswordTooShort(password: String): Boolean {
    return password.isNotEmpty() && password.length < MIN_PASSWORD_LENGTH
}

/**
 * Create account button is enabled only when:
 *  - all fields are filled in
 *  - password and confirm password are equal
 *  - the terms checkbox is checked
 */
fun canCreateAccount(
    firstName: String,
    lastName: String,
    email: String,
    password: String,
    confirmPassword: String,
    agreeToTerms: Boolean
): Boolean {
    return areAllFieldsFilled(firstName, lastName, email, password, confirmPassword) &&
            passwordsMatch(password, confirmPassword) &&
            agreeToTerms
}
