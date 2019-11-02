package com.mobilite.core.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile_image (
    val small: String,
    val large: String,
    val medium: String

)  : Parcelable
