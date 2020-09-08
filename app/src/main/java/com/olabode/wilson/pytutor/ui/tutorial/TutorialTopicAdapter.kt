package com.olabode.wilson.pytutor.ui.tutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.TutorialItemBinding
import com.olabode.wilson.pytutor.models.tutorial.TopicResponse

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */
class TutorialTopicAdapter(private val clickListener: (topic: TopicResponse) -> Unit)
    : ListAdapter<TopicResponse, TutorialTopicAdapter.ViewHolder>(TopicResponse.DIFF_CALLBACK) {


    class ViewHolder(
            private val binding: TutorialItemBinding,
            private val clickListener: (topic: TopicResponse) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var item: TopicResponse? = null

        init {
            binding.root.setOnClickListener {
                item?.let { clickListener.invoke(item!!) }
            }
        }

        fun bind(item: TopicResponse) {
            this.item = item
            binding.topicCount.text = getTopicNumber(adapterPosition + 1)
            binding.title.text = item.Title
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