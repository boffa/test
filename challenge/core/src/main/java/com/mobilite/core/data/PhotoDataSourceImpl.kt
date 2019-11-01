package com.mobilite.core.data

import com.mobilite.core.CoreService
import com.mobilite.core.data.BaseResult
import com.mobilite.core.data.PhotoResponse
import com.mobilite.core.utils.AppExecutors
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotoDataSourceImpl @Inject constructor(private val coreService: CoreService, private val appExecutors: AppExecutors) : PhotoDataSource {
    override suspend fun getPhotos(): BaseResult<PhotoResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

