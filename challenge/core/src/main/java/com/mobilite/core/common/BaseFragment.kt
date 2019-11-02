package com.mobilite.core.common

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    protected lateinit var activity: BaseActivity



    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as BaseActivity
    }


    protected fun toggleLoading(show: Boolean) {
        if (isAdded) {
            activity.toggleLoading(show)
        }
    }
}