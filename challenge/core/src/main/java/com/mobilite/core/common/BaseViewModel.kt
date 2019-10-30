

package com.mobilite.core.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {
    val toggleLoading = MutableLiveData<Boolean>()

    private val parentJob = Job()

    val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    val scope = CoroutineScope(coroutineContext)

    open fun onCreated() {}

    open fun onStart() {}

    open fun onResume() {}

    open fun onPause() {
        toggleLoading.value = false
        clearCoroutines()
    }

    open fun onStop() {}

    open fun onDestroy() {}

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    protected fun clearCoroutines() {
        ///parentJob.cancel()
    }

}