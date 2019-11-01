
package com.mobilite.core

import com.mobilite.core.domain.Photo
import kotlinx.coroutines.Deferred
import retrofit2.http.*


interface CoreService {
    //  photo Service
    @GET("/photos/random/")
    fun getPhotos(@Query("client_id") client_id: String,@Query("count") count: String): Deferred<List<Photo>>

}