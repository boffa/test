package com.mobilite.core.data

import com.mobilite.core.data.BaseResult
import com.mobilite.core.data.PhotoResponse


interface PhotoDataSource {
    suspend fun getPhotos() : BaseResult<PhotoResponse>

}
