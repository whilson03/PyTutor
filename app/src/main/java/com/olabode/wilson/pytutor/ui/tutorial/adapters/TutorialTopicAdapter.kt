package com.olabode.wilson.pytutor.ui.tutorial.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.TutorialItemBinding
import com.olabode.wilson.pytutor.models.Topic

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */
class TutorialTopicAdapter(private val clickListener: (topic: Topic) -> Unit)
    : ListAdapter<Topic, TutorialTopicAdapter.ViewHolder>(Topic.DIFF_CALLBACK) {

    class ViewHolder(
            private val binding: TutorialItemBinding,
            private val clickListener: (topic: Topic) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var item: Topic? = null

        init {
            binding.root.setOnClickListener {
                item?.let { clickListener.invoke(item!!) }
            }
        }

        fun bind(item: Topic) {
            this.item = item
            binding.topicCount.text = getTopicNumber(adapterPosition + 1)
            binding.title.text = item.title
            binding.shortDetail.text = item.description
        }

        private fun getTopicNumber(position: Int): String {
            if (position in 0..9) {
                return "0$position"
            }
            return position.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TutorialItemBinding.inflate(
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