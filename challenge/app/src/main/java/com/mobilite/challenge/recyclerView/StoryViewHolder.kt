package com.mobilite.challenge.recyclerView

import android.view.View
import com.mobilite.core.domain.Photo
import kotlinx.android.synthetic.main.story_item.view.*


class StoryViewHolder (val view: View) : BaseViewHolder<Photo>(view)
{

    override fun bind(item: Photo) {
        //view.imageView.setImageURI(item.images.get(0) as String)
        view.user_imageView.setImageURI(item.user.profile_image.small)
        view.username_textView.setText(item.user.username)
       // view.setOnClickListener { clickListener(item)}

    }


}