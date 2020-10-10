package com.olabode.wilson.pytutor.ui.auth

import com.olabode.wilson.pytutor.utils.Constants

/**
 *   Created by OLABODE WILSON on 10/2/20.
 */
object AuthUtils {

    fun validateLoginDetails(
        email: String,
        password: String
    ): ValidationStates {
        return if (email.isEmpty() || password.isEmpty()) {
            ValidationStates.Error("Fields Cannot be Blank")
        } else if (password.length < Constants.PASSWORD_LENGTH) {
            ValidationStates.Error("Invalid Details")
        } else {
            ValidationStates.Success
        }
    }

    fun validateRegistrationDetails(
        fullName: String,
        email: String,
        password: String,
        confirmPassword: String
    ): ValidationStates {
        return if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            ValidationStates.Error("Fields Cannot be Blank")
        } else if (password != confirmPassword) {
            ValidationStates.Error("Passwords Don't Match")
        } else if (password.length < Constants.PASSWORD_LENGTH) {
            ValidationStates.Error("Password Should Contain 8 Characters")
        } else {
            ValidationStates.Success
        }
    }
}

sealed class ValidationStates {
    object Success : ValidationStates()
    data class Error(val message: String) : ValidationStates()
}