package com.olabode.wilson.pytutor.ui.auth

import com.olabode.wilson.pytutor.utils.Constants
import com.olabode.wilson.pytutor.utils.Messages

/**
 *   Created by OLABODE WILSON on 10/2/20.
 */
object AuthUtils {

    fun validateLoginDetails(
        email: String,
        password: String
    ): ValidationStates {
        return if (email.isEmpty() || password.isEmpty()) {
            ValidationStates.Error(Messages.BLANK_FIELDS_IN_FORM)
        } else if (password.length < Constants.PASSWORD_LENGTH) {
            ValidationStates.Error(Messages.PASSWORD_SHORT_IN_FORM)
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
            ValidationStates.Error(Messages.BLANK_FIELDS_IN_FORM)
        } else if (password != confirmPassword) {
            ValidationStates.Error(Messages.MISMATCH_PASSWORD)
        } else if (password.length < Constants.PASSWORD_LENGTH) {
            ValidationStates.Error(Messages.PASSWORD_SHORT_IN_FORM)
        } else {
            ValidationStates.Success
        }
    }
}

sealed class ValidationStates {
    object Success : ValidationStates()
    data class Error(val message: String) : ValidationStates()
}