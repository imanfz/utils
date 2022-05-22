package com.iman.faizal.utils

import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText

fun EditText.getString(): String {
    return this.text.toString()
}

fun AppCompatEditText.getString(): String {
    return this.text.toString()
}