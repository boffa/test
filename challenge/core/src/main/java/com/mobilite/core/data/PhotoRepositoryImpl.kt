package com.mobilite.core.data

import com.mobilite.core.RemoteDataNotFoundException
import com.mobilite.core.domain.Photo
import javax.inject.Inject


class PhotoRepositoryImpl @Inject constructor(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(): BaseResult<List<Photo>> {

        return when (val result =
            photoDataSource.getPhotos()) {
            is BaseResult.Success -> {
                BaseResult.Success(result.data)
            }
            is BaseResult.Error -> {
                BaseResult.Error(RemoteDataNotFoundException())
            }
        }


      /*  override suspend fun getFavoriteAdvert(
            token: String,
            user: Long,
            latitude: Double,
            longitude: Double
        ): AuthResult<List<Advert>> {
            return when (val result =
                advertsDataSource.getFavoriteAdvert(token, user, latitude, longitude)) {
                is AuthResult.Success -> {
                    AuthResult.Success(result.data)
                }
                is AuthResult.Error -> {
                    AuthResult.Error(RemoteDataNotFoundException())
                }
            }*/

    }


}