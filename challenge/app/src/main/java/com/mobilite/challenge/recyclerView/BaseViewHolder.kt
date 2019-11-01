package com.mobilite.challenge.recyclerView

import android.view.View
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.mobilite.core.domain.Photo

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Photo)
}