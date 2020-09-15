package com.olabode.wilson.pytutor.ui.tutorial.adapters

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.olabode.wilson.pytutor.databinding.ItemBulletTextBinding
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
            if (code.header.isNotEmpty()) {
                binding.header.text = code.header
                binding.header.isVisible = true
            } else {
                binding.header.isVisible = false
            }

            if (code.footer.isNotEmpty()) {
                binding.footer.text = code.footer
                binding.footer.isVisible = true
            } else {
                binding.footer.isVisible = false
            }
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


class BulletViewHolder(val binding: ItemBulletTextBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Lesson) {
        item.body.let {
            binding.text.text = it
        }
    }
}


enum class LessonTypes {
    CODE, TEXT, IMAGE, BULLET
}