package com.example.ushtrimi_2

import org.junit.Test

import org.junit.Assert.*
import com.example.ushtrimi_2.utlis.isSignupFormValid

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun signupFormIsValidWhenAllFieldsAreComplete() {
        assertTrue(
            isSignupFormValid(
                firstName = "Ada",
                lastName = "Lovelace",
                email = "ada@example.com",
                password = "secret",
                confirmPassword = "secret",
                termsAccepted = true
            )
        )
    }

    @Test
    fun signupFormIsInvalidWhenPasswordsDoNotMatch() {
        assertFalse(
            isSignupFormValid(
                firstName = "Ada",
                lastName = "Lovelace",
                email = "ada@example.com",
                password = "secret",
                confirmPassword = "different",
                termsAccepted = true
            )
        )
    }

    @Test
    fun signupFormIsInvalidWhenTermsAreNotAccepted() {
        assertFalse(
            isSignupFormValid(
                firstName = "Ada",
                lastName = "Lovelace",
                email = "ada@example.com",
                password = "secret",
                confirmPassword = "secret",
                termsAccepted = false
            )
        )
    }

    @Test
    fun signupFormIsInvalidWhenPasswordIsShorterThanSixCharacters() {
        assertFalse(
            isSignupFormValid(
                firstName = "Ada",
                lastName = "Lovelace",
                email = "ada@example.com",
                password = "short",
                confirmPassword = "short",
                termsAccepted = true
            )
        )
    }
}