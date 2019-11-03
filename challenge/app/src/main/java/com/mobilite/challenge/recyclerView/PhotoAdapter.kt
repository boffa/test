package com.mobilite.challenge.recyclerView


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.mobilite.challenge.R
import com.mobilite.core.domain.Photo
import java.util.*
import kotlin.collections.ArrayList


class PhotoAdapter(private val photos: ArrayList<Photo>)
    : RecyclerView.Adapter<StoryViewHolder>() {
     var photosCopy = ArrayList<Photo>()
    init {
        photosCopy.addAll(photos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item,parent,false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(photos.get(position))



    }

    override fun getItemCount(): Int = photos.size


    fun filter(text: String) {
        photos.clear()
        if (text.isEmpty()) {
            photos.addAll(photosCopy)
        } else {
            for (item in photosCopy) {
                if (item.user.username.toLowerCase(Locale.ROOT).contains(text) ) {
                    photos.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }


}
