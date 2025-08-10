package com.fit2081.nutritrack_yinshi_34506241.functions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getCurrentFormattedDateTime(): String {
    val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
    return sdf.format(Date())
}