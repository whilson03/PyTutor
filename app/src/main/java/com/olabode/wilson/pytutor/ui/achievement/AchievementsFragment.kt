package com.olabode.wilson.pytutor.ui.achievement

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentAchievementsBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.AchievementItem
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ogheneruona Onobrakpeya on 9/25/20.
 */

@AndroidEntryPoint
class AchievementsFragment : Fragment(R.layout.fragment_achievements) {
    private val binding by viewBinding(FragmentAchievementsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val achievementsListAdapter = AchievementsListAdapter()
        binding.achievementRecycler.adapter = achievementsListAdapter
        achievementsListAdapter.submitList(getDummyList())

        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
    }

    private fun getDummyList(): List<AchievementItem> = List(16) { AchievementItem(R.drawable.ic_round_stars_24, "Baby Steps", "Completed your first lesson") }
}