package com.mobilite.challenge.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilite.challenge.viewModel.MainViewModel
import com.mobilite.core.data.PhotoRepositoryImpl
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: PhotoRepositoryImpl) :
    ViewModelProvider.Factory {

    /*@Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =    MainViewModel(repository) as T
}*/
override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return if (modelClass.isAssignableFrom(MainViewModel::class.java!!)) {
        MainViewModel(this.repository) as T
    } else {
        throw IllegalArgumentException("ViewModel Not Found")
    }


}
}