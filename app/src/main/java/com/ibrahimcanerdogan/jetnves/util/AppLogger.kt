package com.ibrahimcanerdogan.jetnves.util

import android.util.Log
import com.ibrahimcanerdogan.jetnves.BuildConfig

enum class LOGTAG {
    LAYER_DATA,
    LAYER_DOMAIN,
    LAYER_VIEW,
    LAYER_VIEW_MODEL
}

fun logMessage(tag: LOGTAG, message: String) {
    if (BuildConfig.DEBUG) Log.d(tag.name, message)
}