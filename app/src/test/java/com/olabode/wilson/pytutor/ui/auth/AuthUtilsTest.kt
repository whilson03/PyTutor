package com.olabode.wilson.pytutor.ui.auth

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by OLABODE WILSON on 10/2/20.
 */
class AuthUtilsTest {

    @Test
    fun `empty email or password for login returns false`() {
        val result = AuthUtils.validateLoginDetails("", "")

        assertThat(result).isFalse()
    }

    @Test
    fun `password length lesser than six characters for login returns false`() {
        val result = AuthUtils.validateLoginDetails("", "aae")

        assertThat(result).isFalse()
    }

    @Test
    fun `valid name, email , and correctly repeated passwords for registration returns true`() {
        val result = AuthUtils.validateRegistrationDetails(
            fullName = "wilson",
            email = "whilson03@gmail.com",
            password = "password",
            confirmPassword = "password"
        )

        assertThat(result).isTrue()
    }

    @Test
    fun `any empty field for user registration returns false`() {
        val result = AuthUtils.validateRegistrationDetails(
            fullName = "",
            email = "whilson03@gmail.com",
            password = "password",
            confirmPassword = "password"
        )

        assertThat(result).isFalse()
    }
}