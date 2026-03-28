package com.example.clicker42.ui.theme

import android.icu.number.Scale
import java.math.BigDecimal
import java.math.RoundingMode

fun BigDecimal.formatNumber(scale: Int  = 0): String {
    val suffixes = " abcdefghijklmnopqrstuvwxyz"
    var count = 0
    var number = this

    while (number > BigDecimal(1000) && count < suffixes.length) {
        number /= BigDecimal(1000)
        count++
    }

    return "${number.setScale(scale, RoundingMode.FLOOR)}${suffixes[count].uppercase()}"
}