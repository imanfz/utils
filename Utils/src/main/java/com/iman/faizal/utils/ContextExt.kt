package com.iman.faizal.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat

/**
 * Created by Iman Faizal on 21/May/2022
 **/

fun Context.hideKeyboard() {
    val inputMethodManager =
        this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(
        (this as Activity).currentFocus?.windowToken,
        InputMethodManager.HIDE_NOT_ALWAYS
    )
}

fun Context.showKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput((this as Activity).currentFocus, InputMethodManager.SHOW_IMPLICIT)
}

fun Context.longToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

class ToasterMessage {
    companion object {
        fun toastMessage(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}

fun Context.hasPermission(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun Context.showBasicDialog(
    title: String,
    message: String,
    okClicked: (() -> Unit?)? = null,
    cancelClicked: (() -> Unit?)? = null
) {
    AlertDialog.Builder(this).apply {
        setTitle(title)
        setMessage(message)
        setPositiveButton("Ok"
        ) { dialog, _ ->
            // User clicked OK button
            if (okClicked != null) {
                okClicked()
            }
            dialog.dismiss()
        }
        if (cancelClicked != null) {
            setNegativeButton(
                "Cancel"
            ) { dialog, _ ->
                // User cancelled the dialog
                cancelClicked()
                dialog.dismiss()
            }
        }
        create()
        setCancelable(false)
        show()
    }
}