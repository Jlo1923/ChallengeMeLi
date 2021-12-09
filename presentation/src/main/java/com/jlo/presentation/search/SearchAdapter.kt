package com.jlo.presentation.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jlo.presentation.R
import com.jlo.presentation.databinding.ItemSearchBinding

class SearchAdapter(
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    var data: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search, parent, false)
        return SearchViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class SearchViewHolder(
        view: View,
        private val onClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        private val binding = ItemSearchBinding.bind(view)
        private var currentSearch: String? = null

        init {
            itemView.setOnClickListener {
                currentSearch?.let(onClick)
            }
        }

        fun bind(search: String) {
            currentSearch = search
            binding.searchText.text = search
        }
    }
}
