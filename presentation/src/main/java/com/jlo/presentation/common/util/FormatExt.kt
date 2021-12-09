package com.jlo.presentation.common.util

import java.text.NumberFormat

fun Double.toCurrency(): String {
    val numberFormat = NumberFormat.getCurrencyInstance()
    return numberFormat.format(this)
}
