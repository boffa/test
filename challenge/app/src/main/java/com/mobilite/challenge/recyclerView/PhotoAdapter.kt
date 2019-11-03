package com.mobilite.challenge.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mobilite.challenge.R
import com.mobilite.core.domain.Photo


class PhotoAdapter(private val photos: ArrayList<Photo>)
    : DynamicSearchAdapter<Photo>(photos) {

    /* class StoryAdapter(val photos: List<Photo>)
         : RecyclerView.Adapter<StoryViewHolder>() {

         class SearchAdapter1(private val mutableList: MutableList<SearchModel1>) :
     DynamicSearchAdapter<SearchModel1>(mutableList) {*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item,parent,false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
            holder.bind(photos.get(position))

    }

    override fun getItemCount(): Int = photos.size


}
