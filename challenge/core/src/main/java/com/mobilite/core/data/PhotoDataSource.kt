package com.mobilite.core.data

import com.mobilite.core.domain.Photo


interface PhotoDataSource {
    suspend fun getPhotos() : BaseResult<List<Photo>>

}
