package com.olabode.wilson.pytutor.ui.auth

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by OLABODE WILSON on 10/2/20.
 */
class AuthUtilsTest {

    // LOGIN

    @Test
    fun `empty email or password for login returns error state`() {
        val result = AuthUtils.validateLoginDetails("", "")

        assertThat(result is ValidationStates.Error).isTrue()
    }

    @Test
    fun `password length lesser than six characters for login returns error state`() {
        val result = AuthUtils.validateLoginDetails("", "aae")

        assertThat(result is ValidationStates.Error).isTrue()
    }

    @Test
    fun `correctly filled email and password for login returns success state`() {
        val result = AuthUtils
            .validateLoginDetails("whilson@gmail.com", "password")

        assertThat(result is ValidationStates.Success).isTrue()
    }

    //REGISTER

    @Test
    fun `valid name, email , and correctly repeated passwords for registration returns success`() {
        val result = AuthUtils.validateRegistrationDetails(
            fullName = "wilson",
            email = "whilson03@gmail.com",
            password = "password",
            confirmPassword = "password"
        )

        assertThat(result is ValidationStates.Success).isTrue()
    }

    @Test
    fun `any empty field for user registration returns error state`() {
        val result = AuthUtils.validateRegistrationDetails(
            fullName = "",
            email = "whilson03@gmail.com",
            password = "password",
            confirmPassword = "password"
        )
        assertThat(result is ValidationStates.Error).isTrue()
    }

    @Test
    fun `short password for user registration returns error state`() {
        val result = AuthUtils.validateRegistrationDetails(
            fullName = "",
            email = "whilson03@gmail.com",
            password = "pass",
            confirmPassword = "pass"
        )
        assertThat(result is ValidationStates.Error).isTrue()
    }
}