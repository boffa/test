package com.mobilite.challenge.recyclerView


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.mobilite.challenge.R
import com.mobilite.core.domain.Photo
import java.util.*
import kotlin.collections.ArrayList


class PhotoAdapter(private val photos: ArrayList<Photo>,val clickListener: ((Photo) -> Unit )={})
    : RecyclerView.Adapter<PhotoViewHolder>() {
     var photosCopy = ArrayList<Photo>()
    init {
        photosCopy.addAll(photos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item,parent,false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos.get(position),clickListener)



    }

    override fun getItemCount(): Int = photos.size


    fun filter(text: String) {
        photos.clear()
        if (text.isEmpty()) {
            photos.addAll(photosCopy)
        } else {
            for (item in photosCopy) {
                if (item.user.username.toLowerCase(Locale.ROOT).trim().contains(text) ) {
                    photos.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }


}
