package com.iman.faizal.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(format: String, locale: Locale = Locale.getDefault()): Date? {
    return SimpleDateFormat(format, locale).parse(this)
}

fun String.getNumber() : String {
    return this.filter { it.isDigit() }
}

fun String.getFirstName(): String {
    trim().apply {
        if (isBlank() || !contains(" ")) {
            return this
        }
        return split(" ").first().toString()
    }
}