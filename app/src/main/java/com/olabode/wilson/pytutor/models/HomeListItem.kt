package com.olabode.wilson.pytutor.models

import androidx.recyclerview.widget.DiffUtil

/**
 *   Created by OLABODE WILSON on 9/7/20.
 */
data class HomeListItem(val id: Int, val imagesRes: Int, val title: String) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<HomeListItem>() {
            override fun areItemsTheSame(oldItem: HomeListItem, newItem: HomeListItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HomeListItem, newItem: HomeListItem): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}