package com.olabode.wilson.pytutor.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.ItemHomeTopicBinding
import com.olabode.wilson.pytutor.models.HomeListItem

/**
 *   Created by OLABODE WILSON on 9/7/20.
 */
class HomeListAdapter(private val clickListener: (homeListItem: HomeListItem) -> Unit)
    : ListAdapter<HomeListItem, HomeListAdapter.ViewHolder>(HomeListItem.diffCallback) {

    class ViewHolder(
            private val binding: ItemHomeTopicBinding,
            private val clickListener: (homeListItem: HomeListItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var item: HomeListItem? = null

        init {
            binding.root.setOnClickListener {
                item?.let { clickListener.invoke(item!!) }
            }
        }

        fun bind(item: HomeListItem) {
            this.item = item
            binding.icons.setImageResource(item.imagesRes)
            binding.title.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeTopicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return ViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}