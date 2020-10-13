package com.olabode.wilson.pytutor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ogheneruona Onobrakpeya on 10/10/20.
 */

@Parcelize
data class Exercise(
    val id: String,
    val title: String,
    val difficulty: String,
    val question: String,
    val solution: String
) : Parcelable, Comparable<Exercise> {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Exercise>() {
            override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
                return  oldItem == newItem
            }
        }

        val difficultyMap: Map<String, Int> = mapOf("Easy" to 1, "Medium" to 2, "Hard" to 3)
    }

    // Compare by difficulty
    override fun compareTo(other: Exercise): Int {
        val thisDifficulty: Int = difficultyMap[this.difficulty] ?: error("")
        val otherDifficulty: Int = difficultyMap[other.difficulty] ?: error("")

        return if (thisDifficulty != otherDifficulty) {
            thisDifficulty - otherDifficulty
        }
        else 0
    }
}

