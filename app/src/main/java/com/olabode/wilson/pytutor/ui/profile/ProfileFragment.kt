package com.olabode.wilson.pytutor.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentProfileBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.AchievementItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private lateinit var achievementsListAdapter: AchievementsListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        achievementsListAdapter = AchievementsListAdapter()
        binding.achievementRecycler.adapter = achievementsListAdapter
        achievementsListAdapter.submitList(getDummyList())
    }


    private fun getDummyList(): List<AchievementItem> = List(8) { AchievementItem(R.drawable.ic_round_stars_24, "Baby Steps", "Completed your first lesson") }
}