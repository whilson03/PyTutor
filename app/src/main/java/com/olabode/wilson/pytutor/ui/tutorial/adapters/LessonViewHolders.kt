package com.olabode.wilson.pytutor.ui.tutorial.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.olabode.wilson.pytutor.databinding.ItemTutorialBodyBinding
import com.olabode.wilson.pytutor.databinding.ItemTutorialImageBinding
import com.olabode.wilson.pytutor.databinding.ItemTutorialSnippetBinding
import com.olabode.wilson.pytutor.models.tutorial.Lesson

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
class ImageViewHolder(val binding: ItemTutorialImageBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Lesson) {
        if (item.imageUrl.isNotEmpty()) {
            binding.tutorialImage.load(item.imageUrl)
        }
    }
}


class CodeViewHolder(val binding: ItemTutorialSnippetBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Lesson) {
        item.codeSnippet?.let { code ->
            binding.codeText.text = code.code
        }
    }
}


class TextViewHolder(val binding: ItemTutorialBodyBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Lesson) {
        item.body.let {
            binding.bodyText.text = it
        }
    }
}


enum class LessonTypes {
    CODE, TEXT, IMAGE
}