package com.mobilite.core.common

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.annotation.IntDef
import androidx.lifecycle.Observer
import java.lang.annotation.RetentionPolicy


abstract class BaseViewModelFragment <out T : BaseViewModel> : BaseFragment() {

    protected abstract fun getViewModel(): T?

    private fun initObservers() {
        getViewModel()?.toggleLoading?.observe(this, Observer { toggleLoading(it!!) })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  initObservers()
    }
    fun EditText.onChange(cb: (String) -> Unit) {
        this.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { cb(s.toString()) }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun onStart() {
        getViewModel()?.onStart()
        super.onStart()
    }

    override fun onResume() {
        getViewModel()?.onResume()
        super.onResume()
    }

    override fun onPause() {
        getViewModel()?.onPause()
        super.onPause()
    }

    override fun onStop() {
        getViewModel()?.onStop()
        super.onStop()
    }

    override fun onDestroyView() {
        getViewModel()?.onDestroy()
        super.onDestroyView()
    }




}