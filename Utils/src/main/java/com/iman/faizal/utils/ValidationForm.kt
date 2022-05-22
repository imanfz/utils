package com.iman.faizal.utils

import android.content.Context
import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

/**
 * Created by Iman Faizal on 21/May/2022
 **/

class ValidationForm (private val context: Context) {

    /**
    "(?=.*[0-9])" +         //at least 1 digit
    "(?=.*[a-zA-Z])" +      //any letter
    "(?=\\S+$)" +           //no white spaces
    ".{8,}" +               //at least 8 characters
    "$");
     */

    private val passwordPattern by lazy { Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,}$") }

    private val strongPasswordPattern by lazy { Pattern.compile("(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$") }

    private val phonePattern by lazy { Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$") }

    fun isValidInput(
        text: String,
        textInputLayout: TextInputLayout
    ): Boolean {
        return if (text.isBlank()) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = context.getString(R.string.form_must_be_not_empty)
            textInputLayout.requestFocus()
            false
        } else {
            textInputLayout.isErrorEnabled = false
            textInputLayout.error = null
            true
        }
    }

    fun isValidInputLength(
        text: String,
        textInputLayout: TextInputLayout
    ): Boolean {
        return if (text.isBlank()) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error =
                context.getString(R.string.form_must_be_not_empty)
            textInputLayout.requestFocus()
            false
        } else {
            if (text.length < 4) {
                textInputLayout.isErrorEnabled = true
                textInputLayout.error = context.getString(R.string.name_must_be_3_char)
                textInputLayout.requestFocus()
                false
            } else {
                textInputLayout.isErrorEnabled = false
                textInputLayout.error = null
                true
            }
        }
    }

    fun isValidEmail(
        emailText: String,
        textInputLayout: TextInputLayout
    ): Boolean {
        return if (emailText.isBlank()) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error =
                context.getString(R.string.form_must_be_not_empty)
            textInputLayout.requestFocus()
            false
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                textInputLayout.isErrorEnabled = true
                textInputLayout.error =
                    context.getString(R.string.email_format)
                textInputLayout.requestFocus()
                false
            } else {
                textInputLayout.isErrorEnabled = false
                textInputLayout.error = null
                true
            }
        }
    }

    fun isValidPhone(
        phone: String,
        textInputLayout: TextInputLayout
    ): Boolean {
        return if (phone.isBlank()) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error =
                context.getString(R.string.form_must_be_not_empty)
            textInputLayout.requestFocus()
            false
        } else {
            if (!phonePattern.matcher(phone).matches() || phone.length < 11) {
                textInputLayout.isErrorEnabled = true
                textInputLayout.error =
                    context.getString(R.string.phone_format)
                textInputLayout.requestFocus()
                false
            } else {
                textInputLayout.isErrorEnabled = false
                textInputLayout.error = null
                true
            }
        }
    }

    fun isValidPhoneOrEmail(
        text: String,
        textInputLayout: TextInputLayout
    ): Boolean {
        return if (text.isBlank()) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error =
                context.getString(R.string.form_must_be_not_empty)
            textInputLayout.requestFocus()
            false
        } else {
            textInputLayout.isErrorEnabled = false
            when {
                phonePattern.matcher(text).matches() -> {
                    textInputLayout.error = null
                    true
                }
                Patterns.EMAIL_ADDRESS.matcher(text).matches() -> {
                    textInputLayout.error = null
                    true
                }
                else -> {
                    textInputLayout.isErrorEnabled = true
                    textInputLayout.error =
                        context.getString(R.string.phone_or_email_format)
                    textInputLayout.requestFocus()
                    false
                }
            }
        }
    }

    fun isValidPassword(
        password: String,
        textInputLayout: TextInputLayout
    ): Boolean {
        return if (password.isBlank()) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error =
                context.getString(R.string.form_must_be_not_empty)
            textInputLayout.requestFocus()
            false
        } else {
            if (!passwordPattern.matcher(password).matches()) {
                textInputLayout.isErrorEnabled = true
                textInputLayout.error =
                    context.getString(R.string.password_format)
                textInputLayout.requestFocus()
                false
            } else {
                textInputLayout.isErrorEnabled = false
                textInputLayout.error = null
                true
            }
        }
    }

    fun isValidStrongPassword(
        password: String,
        textInputLayout: TextInputLayout
    ): Boolean {
        return if (password.isBlank()) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error =
                context.getString(R.string.form_must_be_not_empty)
            textInputLayout.requestFocus()
            false
        } else {
            if (!strongPasswordPattern.matcher(password).matches()) {
                textInputLayout.isErrorEnabled = true
                textInputLayout.error =
                    context.getString(R.string.strong_password_format)
                textInputLayout.requestFocus()
                false
            } else {
                textInputLayout.isErrorEnabled = false
                textInputLayout.error = null
                true
            }
        }
    }

    fun isNewValidPassword(
        password: String
    ): List<PasswordValidation> {
        val list: ArrayList<PasswordValidation> = arrayListOf()
        if (password.contains(Regex("[a-z]"))) list.add(PasswordValidation.LOWERCASE)
        if (password.contains(Regex("[A-Z]"))) list.add(PasswordValidation.UPPERCASE)
        if (password.contains(Regex("[0-9]"))) list.add(PasswordValidation.DIGIT)
        if (password.contains(Regex(".*[!@#$%^&*+=/?].*"))) list.add(PasswordValidation.CHARACTER)
        return list
    }

    fun isMatchPassword(
        password: String,
        confirmPassword: String,
        textInputLayout: TextInputLayout
    ): Boolean {
        return  if (password != confirmPassword) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = context.getString(R.string.password_not_match)
            false
        } else {
            textInputLayout.isErrorEnabled = false
            textInputLayout.error = null
            true
        }
    }
}