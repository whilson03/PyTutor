package com.olabode.wilson.pytutor.ui.tutorial.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.ItemBulletTextBinding
import com.olabode.wilson.pytutor.databinding.ItemCodeSnippetBinding
import com.olabode.wilson.pytutor.databinding.ItemTutorialBodyBinding
import com.olabode.wilson.pytutor.models.tutorial.Tutorial

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
class LessonAdapter : ListAdapter<Tutorial, RecyclerView.ViewHolder>(LessonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            LessonTypes.TEXT.ordinal -> {
                val binding = ItemTutorialBodyBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                TextViewHolder(binding)
            }

            LessonTypes.BULLET.ordinal -> {
                val binding = ItemBulletTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                BulletViewHolder(binding)
            }

            else -> {
                val binding = ItemCodeSnippetBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CodeViewHolder(binding, parent.context)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val lesson = getItem(position)
        when (lesson.type) {
            LessonTypes.CODE.ordinal -> (holder as CodeViewHolder).bind(lesson)
            LessonTypes.TEXT.ordinal -> (holder as TextViewHolder).bind(lesson)
            LessonTypes.BULLET.ordinal -> (holder as BulletViewHolder).bind(lesson)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }
}

class LessonDiffCallback : DiffUtil.ItemCallback<Tutorial>() {
    override fun areItemsTheSame(oldItem: Tutorial, newItem: Tutorial): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Tutorial, newItem: Tutorial): Boolean {
        return oldItem == newItem
    }
}