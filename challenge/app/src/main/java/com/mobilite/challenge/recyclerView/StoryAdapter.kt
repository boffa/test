package com.mobilite.challenge.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilite.challenge.R
import com.mobilite.core.domain.Photo


class StoryAdapter(val photos: ArrayList<Photo>)
    : RecyclerView.Adapter<StoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_item,parent,false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
            holder.bind(photos.get(position))
    }

    override fun getItemCount(): Int = photos.size

}
