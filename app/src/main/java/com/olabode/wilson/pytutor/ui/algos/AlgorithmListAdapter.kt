package com.olabode.wilson.pytutor.ui.algos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.ItemAlgorithmsBinding
import com.olabode.wilson.pytutor.models.Algorithm
import com.olabode.wilson.pytutor.utils.Utils

/**
 *   Created by OLABODE WILSON on 9/29/20.
 */
class AlgorithmListAdapter(private val clickListener: (algorithm: Algorithm) -> Unit) :
    ListAdapter<Algorithm, AlgorithmListAdapter.ViewHolder>(Algorithm.DIFF_CALLBACK) {

    class ViewHolder(
        private val binding: ItemAlgorithmsBinding,
        private val clickListener: (algorithm: Algorithm) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var item: Algorithm? = null

        init {
            binding.root.setOnClickListener {
                item?.let {
                    clickListener.invoke(it)
                }
            }
        }

        fun bind(item: Algorithm) {
            this.item = item
            binding.title.text = item.title
            binding.shortDetail.text = item.description
            binding.topicCount.text = Utils.getAdapterNumberLabel(adapterPosition + 1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAlgorithmsBinding.inflate(
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