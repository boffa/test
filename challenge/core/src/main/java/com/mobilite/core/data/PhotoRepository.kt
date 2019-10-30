package com.gyming.core.data

import com.mobilite.core.data.BaseResult
import com.mobilite.core.data.PhotoResponse


interface PhotoRepository {
    suspend fun getPhotos() : BaseResult<PhotoResponse>
}

