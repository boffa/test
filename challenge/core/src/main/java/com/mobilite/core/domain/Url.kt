package com.mobilite.core.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Url(
    val raw: String,
    val full: String,
    val small: String,
    val regular: String,
    val thumb: String
): Parcelable