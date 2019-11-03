package com.mobilite.challenge.recyclerView

import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.mobilite.core.common.Searchable

abstract class DynamicSearchAdapter<T : Searchable>(private val searchableList: ArrayList<T>) :
        RecyclerView.Adapter<PhotoViewHolder>(), Filterable {

    // Single not-to-be-modified copy of original data in the list.
    private val originalList = ArrayList(searchableList)
    // a method-body to invoke when search returns nothing. It can be null.
    private var onNothingFound: (() -> Unit)? = null

    /**
     * Searches a specific item in the list and updates adapter.
     * if the search returns empty then onNothingFound callback is invoked if provided which can be used to update UI
     * @param s the search query or text. It can be null.
     * @param onNothingFound a method-body to invoke when search returns nothing. It can be null.
     */
    fun search(s: String?, onNothingFound: (() -> Unit)?) {
        this.onNothingFound = onNothingFound
        filter.filter(s)

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            private val filterResults = FilterResults()
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                searchableList.clear()
                if (constraint.isNullOrBlank()) {
                    searchableList.addAll(originalList)
                } else {
                    val searchResults = originalList.filter { it.getSearchCriteria().contains(constraint) }
                    searchableList.addAll(searchResults)
                }
                return filterResults.also {
                    it.values = searchableList
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                // no need to use "results" filtered list provided by this method.
                if (searchableList.isNullOrEmpty())
                    onNothingFound?.invoke()
                notifyDataSetChanged()

            }
        }
    }




}