package com.olabode.wilson.pytutor.ui.learn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.ItemTopicBinding
import com.olabode.wilson.pytutor.interfaces.OnItemClickListener
import com.olabode.wilson.pytutor.models.Tutorial
import com.olabode.wilson.pytutor.ui.learn.TutorialsRecyclerAdapter.TutorialViewHolder

/**
 *   Created by OLABODE WILSON on 8/11/20.
 */
class TutorialsRecyclerAdapter : ListAdapter<Tutorial, TutorialViewHolder>(TutorialComparator) {


    private var clickListener: OnItemClickListener<Tutorial>? = null

    fun setOntutorialClickedListener(listener: OnItemClickListener<Tutorial>) {
        clickListener = listener
    }


    inner class TutorialViewHolder constructor(private val binding: ItemTopicBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Tutorial) {
            binding.lockIcon.isVisible = item.isLocked
            binding.progressBar.progress = item.completionPercent
            binding.title.text = item.topic
            binding.shortDetail.text = item.shortDescription
            binding.topicCount.text = getTopicNumber(adapterPosition + 1)

            binding.root.setOnClickListener {
                if (clickListener != null && adapterPosition != RecyclerView.NO_POSITION) {
                    clickListener!!.onClick(getItem(adapterPosition))
                }
            }
        }
    }

    private fun getTopicNumber(position: Int): String {
        if (position in 0..9) {
            return "0$position"
        }
        return position.toString()
    }

    object TutorialComparator : DiffUtil.ItemCallback<Tutorial>() {
        override fun areItemsTheSame(oldItem: Tutorial, newItem: Tutorial): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Tutorial, newItem: Tutorial): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTopicBinding.inflate(
                layoutInflater, parent, false
        )
        return TutorialViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TutorialViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


