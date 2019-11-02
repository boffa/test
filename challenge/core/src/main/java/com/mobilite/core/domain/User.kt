package com.mobilite.core.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class User (
    val  username: String,
    val  profile_image: @RawValue Profile_image


)  : Parcelable
