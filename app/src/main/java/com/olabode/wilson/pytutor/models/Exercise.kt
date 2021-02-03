package com.olabode.wilson.pytutor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ogheneruona Onobrakpeya on 10/10/20.
 */

@Parcelize
data class Exercise(
        var id: String,
        val title: String,
        val difficulty: Int,
        val question: String,
        val solution: String,
        val postedBy: String,
        val tags: Map<Int, String>,
        val datePosted: String = ""
) : Parcelable {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Exercise>() {
            override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
                return oldItem.id === newItem.id
            }

            override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
                return oldItem == newItem
            }
        }
    }
}

