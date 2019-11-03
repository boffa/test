package com.mobilite.challenge.recyclerView

import android.view.View
import com.mobilite.core.domain.Photo
import kotlinx.android.synthetic.main.photo_item.view.*
import kotlinx.android.synthetic.main.photo_item.view.user_imageView
import kotlinx.android.synthetic.main.photo_item.view.username_textView

class PhotoViewHolder (val view: View) : BaseViewHolder<Photo>(view)
{
    override fun bind(item: Photo, clickListener: (Photo) -> Unit) {
        view.user_imageView.setImageURI(item.urls.small)
        view.username_textView.setText(item.user.username)
        view.date_textView.setText(item.created_at)
        view.setOnClickListener { clickListener(item)}
    }

}