package com.khaled.nytimesmostpopulararticles.utils

import android.content.Context
import android.util.TypedValue

fun convertDpToPixels(context: Context, dp: Float) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    dp,
    context.resources.displayMetrics
)
