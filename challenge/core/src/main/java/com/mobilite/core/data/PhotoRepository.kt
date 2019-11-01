package com.mobilite.core.data

import com.mobilite.core.domain.Photo


interface PhotoRepository {
    suspend fun getPhotos() : BaseResult<List<Photo>>
}

