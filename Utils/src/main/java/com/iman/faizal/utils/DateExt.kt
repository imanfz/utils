package com.iman.faizal.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    return SimpleDateFormat(format, locale).format(this)
}