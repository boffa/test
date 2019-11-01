package com.mobilite.core.data

import com.mobilite.core.CoreService
import com.mobilite.core.domain.Photo
import com.mobilite.core.utils.AppExecutors
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotoDataSourceImpl @Inject constructor(private val coreService: CoreService, private val appExecutors: AppExecutors) : PhotoDataSource {
    override suspend fun getPhotos(): BaseResult<List<Photo>> = withContext(appExecutors.networkContext) {
        val request = coreService.getPhotos("8a57e463181726b24e1323b60fed83cb917f6e29d7b161d917f4c1f7f3b6c8d2","16")
        val response = request.await()
        BaseResult.Success(response)
    }


  /*  override suspend fun getFavoriteAdvert(
        token : String,
        user: Long,
        latitude: Double,
        longitude: Double
    ): AuthResult<List<Advert>> =
        withContext(appExecutors.networkContext) {
            val request = coreService.getFavoriteAdvert(token,user, latitude, longitude)
            val response = request.await()
            AuthResult.Success(response)
        }
*/
}

