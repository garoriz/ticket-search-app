package com.garif.core1

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun showMessage(view: View, stringId: Int) {
    Snackbar.make(
        view,
        stringId,
        Snackbar.LENGTH_LONG
    ).show()
}