package com.olabode.wilson.pytutor.ui.exercise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.ItemExercisesBinding
import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.models.remote.exercise.DIFFICULTY
import com.olabode.wilson.pytutor.utils.Utils

/**
 * Created by Ogheneruona Onobrakpeya on 10/10/20.
 */

class ExerciseListAdapter(private val clickListener: (exercise: Exercise) -> Unit) :
        ListAdapter<Exercise, ExerciseListAdapter.ViewHolder>(Exercise.DIFF_CALLBACK) {

    class ViewHolder(
            private val binding: ItemExercisesBinding,
            private val clickListener: (exercise: Exercise) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var item: Exercise? = null

        init {
            binding.root.setOnClickListener {
                item?.let {
                    clickListener.invoke(it)
                }
            }
        }

        fun bind(item: Exercise) {
            this.item = item
            binding.title.text = item.title
            binding.difficulty.text = getDifficulty(item.difficulty)
            binding.topicCount.text = Utils.getAdapterNumberLabel(adapterPosition + 1)
        }

        private fun getDifficulty(difficulty: Int): String {
            return when (difficulty) {
                DIFFICULTY.EASY.ordinal -> "Easy"
                DIFFICULTY.MEDIUM.ordinal -> "Medium"
                else -> "Hard"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemExercisesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((getItem(position)))
    }

}