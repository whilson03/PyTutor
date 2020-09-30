package com.olabode.wilson.pytutor.ui.achievement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.ItemAchievementsBinding
import com.olabode.wilson.pytutor.models.AchievementItem

class AchievementsViewHolder(private val binding: ItemAchievementsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: AchievementItem) {
        binding.badgeIcon.setImageResource(item.badgeIconRes)
        binding.achievementTitle.text = item.achievementTitle
        binding.achiementDetail.text = item.achievementDetails
    }
}

class AchievementsListAdapter : ListAdapter<AchievementItem, AchievementsViewHolder>(DIFF_CONFIG) {
    companion object {
        val DIFF_CONFIG = object : DiffUtil.ItemCallback<AchievementItem>() {
            override fun areItemsTheSame(
                oldItem: AchievementItem,
                newItem: AchievementItem
            ): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(
                oldItem: AchievementItem,
                newItem: AchievementItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementsViewHolder {
        val binding =
            ItemAchievementsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AchievementsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AchievementsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}