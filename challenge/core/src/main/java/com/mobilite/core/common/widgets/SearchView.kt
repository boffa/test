package com.mobilite.core.common.widgets

import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import com.mobilite.core.R
import kotlinx.android.synthetic.main.search_view.view.*


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class SearchView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
): RelativeLayout(context, attrs, defStyle, defStyleRes), View.OnFocusChangeListener,View.OnClickListener {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.search_view, this, true)
        //search_editText.setOnFocusChangeListener(this)
        clear_btn.setOnClickListener(this)
     //   handleCancelTextVisibility(rootView)
        setData()
    }
    fun setData(){
        search_editText.onChange { sb ->
            if (sb.length>0) {
                clear_btn.visibility = View.VISIBLE
            }else
                clear_btn.visibility = View.GONE
        }
    }

    fun EditText.onChange(cb: (String) -> Unit) {
        this.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { cb(s.toString()) }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun onFocusChange(p0: View?, isFocused: Boolean) {
        if (isFocused) {
          //  search_left_guide.setGuidelinePercent(0.7f)
          /*  cancel_tv.visibility = View.VISIBLE
            cancel_tv.animation = inFromRightAnimation()*/
        }else{
        //    search_left_guide.setGuidelinePercent(0.853f)
            //cancel_tv.visibility = View.GONE
        }
    }

    private fun inFromRightAnimation(): Animation {

        val inFromRight = TranslateAnimation(
            Animation.RELATIVE_TO_PARENT, +1.0f,
            Animation.RELATIVE_TO_PARENT, 0.0f,
            Animation.RELATIVE_TO_PARENT, 0.0f,
            Animation.RELATIVE_TO_PARENT, 0.0f
        )
        inFromRight.duration = 200
        inFromRight.interpolator = AccelerateInterpolator()
        return inFromRight
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.clear_btn ->{
                search_editText.text.clear()
            }
        }

    }




}