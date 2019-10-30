package com.gyming.core.data

import com.mobilite.core.data.BaseResult
import com.mobilite.core.data.PhotoResponse
import javax.inject.Inject


class PhotoRepositoryImpl @Inject constructor(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(): BaseResult<PhotoResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}