
package com.mobilite.challenge.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobilite.core.common.BaseViewModel
import com.mobilite.core.data.BaseResult
import com.mobilite.core.data.PhotoRepositoryImpl
import com.mobilite.core.domain.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.util.ArrayList
import javax.inject.Inject



@Suppress("UNCHECKED_CAST")
class MainViewModel  @Inject constructor(private val photoRepositoryImpl: PhotoRepositoryImpl) : BaseViewModel() {

    val resultPhotos = MutableLiveData<ArrayList<Photo>>()
    val errorMessage = MutableLiveData<String>()

    fun getResultPhotos() :LiveData<ArrayList<Photo>>
    {
        return resultPhotos
    }

    fun getPhotos() {
        toggleLoading.value = true

        scope.launch(Dispatchers.Main) {
            try {
                val data = photoRepositoryImpl.getPhotos()

                    if (data is BaseResult.Success<*>) {
                        toggleLoading.postValue(false)
                        val response = data.data as ArrayList<Photo>
                        if (!response.isEmpty()) {
                            resultPhotos.postValue(response)
                        }
                        else {
                            errorMessage.postValue("erreur")
                        }
                    } else {
                        toggleLoading.postValue(false)
                        errorMessage.postValue("erreur")
                    }

            } catch (e: Exception) {
                toggleLoading.postValue(false)
                if (e is SocketTimeoutException)
                    Log.e("Time out execpetion :", "Timeout == " + e.message)
                else
                    Log.e("NETWORK ERROR :", "ENTERED CATCH == " + e.message)

            }
        }
    }
}

