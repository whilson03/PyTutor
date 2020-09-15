package com.olabode.wilson.pytutor.ui.tutorial.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.ItemBulletTextBinding
import com.olabode.wilson.pytutor.databinding.ItemTutorialBodyBinding
import com.olabode.wilson.pytutor.databinding.ItemTutorialImageBinding
import com.olabode.wilson.pytutor.databinding.ItemTutorialSnippetBinding
import com.olabode.wilson.pytutor.models.tutorial.Lesson

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
class LessonAdapter : ListAdapter<Lesson, RecyclerView.ViewHolder>(LessonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            LessonTypes.IMAGE.ordinal -> {
                val binding = ItemTutorialImageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
                ImageViewHolder(binding)
            }

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
                val binding = ItemTutorialSnippetBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
                CodeViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val lesson = getItem(position)
        when (lesson.type) {
            LessonTypes.CODE.ordinal -> (holder as CodeViewHolder).bind(lesson)
            LessonTypes.IMAGE.ordinal -> (holder as ImageViewHolder).bind(lesson)
            LessonTypes.TEXT.ordinal -> (holder as TextViewHolder).bind(lesson)
            LessonTypes.BULLET.ordinal -> (holder as BulletViewHolder).bind(lesson)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }
}

class LessonDiffCallback : DiffUtil.ItemCallback<Lesson>() {
    override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
        return oldItem == newItem
    }

}