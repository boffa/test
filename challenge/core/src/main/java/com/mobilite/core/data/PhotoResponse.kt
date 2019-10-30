package com.mobilite.core.data

import com.mobilite.core.domain.Url
import kotlinx.android.parcel.RawValue

data class PhotoResponse (
    val id: String,
    val created_at: String,
    val updated_at: String,
    val promoted_at: String,
    val width: Int,
    val height: Int,
    val color: String,
    val description: String,
    val alt_description: String,
    val urls: @RawValue Url
    )
