package com.example.core.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.Locale

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun Fragment.navigateSafe(id: Int) {
    findNavController().navigate(id)
}

fun Fragment.navigateBack() {
    findNavController().popBackStack()
}

fun Float.formatToTwoDecimalPlaces(): String {
    return String.format(Locale.getDefault(), "%.2f", this)
}
