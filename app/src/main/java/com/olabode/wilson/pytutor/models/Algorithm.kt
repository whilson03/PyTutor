package com.olabode.wilson.pytutor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/27/20.
 */
@Parcelize
data class Algorithm(
        val id: String,
        val title: String,
        val description: String,
        val body: String
) : Parcelable {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Algorithm>() {
            override fun areItemsTheSame(oldItem: Algorithm, newItem: Algorithm): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Algorithm, newItem: Algorithm): Boolean {
                return oldItem == newItem
            }

        }
    }
}