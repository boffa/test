package com.mobilite.challenge.recyclerView

import android.view.View
import com.mobilite.core.domain.Photo
import kotlinx.android.synthetic.main.story_item.view.*
import com.facebook.drawee.generic.RoundingParams
import android.R
import android.app.Application
import androidx.core.content.ContextCompat.getColor


class StoryViewHolder (val view: View) : BaseViewHolder<Photo>(view)
{
    override fun bind(item: Photo, clickListener: (Photo) -> Unit) {
        view.user_imageView.setImageURI(item.user.profile_image.small)

        val color = getColor(view.context,R.color.darker_gray)
        val roundingParams = RoundingParams.fromCornersRadius(5f)
        roundingParams.roundAsCircle = true
        roundingParams.setBorder(color, 9.0f)

        if(item.seen) {
            view.user_imageView.hierarchy.roundingParams = roundingParams
        }

        view.username_textView.setText(item.user.username)
        view.setOnClickListener {
            item.seen = true
            clickListener(item)}

    }

}