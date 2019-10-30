
package com.mobilite.core.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import com.mobilite.core.ChallengeBaseApplication
import com.mobilite.core.R
import com.mobilite.core.utils.KeyboardUtil
import kotlinx.android.synthetic.main.layout_loading.*

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var container: ViewGroup
    private lateinit var loading: View
    var isBottomSheetVisible : MutableLiveData<Boolean>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLoading()
        if (isBottomSheetVisible == null)
            isBottomSheetVisible = MutableLiveData()
    }

    private fun initLoading() {
        container = findViewById<View>(android.R.id.content) as ViewGroup
        loading = LayoutInflater.from(this).inflate(R.layout.layout_loading, container, false)
        loading.setOnTouchListener { _, _ -> true }
    }



    fun toggleLoading(show: Boolean)  {
        synchronized(ChallengeBaseApplication.coreComponent) {
            if (!isDestroyed) {
                container.removeView(loading)
                if (show) {
                    container.addView(loading)
                }
            }
        }
    }

    fun replaceFragment(fragment: BaseFragment, container: Int) {

        KeyboardUtil.hideKeyboard(fragment.activity)
        val className = fragment.javaClass.name
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.pull_in_right, R.anim.push_out_left, R.anim.pull_in_left, R.anim.push_out_right)
            .replace(container, fragment, className)
            .addToBackStack(className)
            .commit()
        isBottomSheetVisible?.postValue(true)
    }

    fun addFragment(fragmentToHide:BaseFragment ,fragment: BaseFragment, container: Int) {

        KeyboardUtil.hideKeyboard(fragment.activity)
        val className = fragment.javaClass.name
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.pull_in_right, R.anim.push_out_left, R.anim.pull_in_left, R.anim.push_out_right)
            .hide(fragmentToHide)
            .add(container,fragment,className)
            .addToBackStack(null)
            .commitAllowingStateLoss()
        isBottomSheetVisible?.postValue(true)
    }

    fun replaceFragmentNoAddToBackStack(fragment: BaseFragment, container: Int) {

        KeyboardUtil.hideKeyboard(fragment.activity)
        val className = fragment.javaClass.name
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.pull_in_right, R.anim.push_out_left, R.anim.pull_in_left, R.anim.push_out_right)
            .add(container, fragment, className)
            .commit()
        isBottomSheetVisible?.postValue(true)
    }

    override fun onBackPressed() {
        val f =
            supportFragmentManager.findFragmentByTag("")
        if (f != null && f.isVisible) {
            //DO NOTHING
        } else {
            super.onBackPressed()
        }
        isBottomSheetVisible?.postValue(true)

    }
}