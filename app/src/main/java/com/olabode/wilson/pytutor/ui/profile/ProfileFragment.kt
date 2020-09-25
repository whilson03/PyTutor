package com.olabode.wilson.pytutor.ui.profile

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentProfileBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.AchievementItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var achievementsListAdapter: AchievementsListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        achievementsListAdapter = AchievementsListAdapter()
//        binding.achievementRecycler.adapter = achievementsListAdapter
//        achievementsListAdapter.submitList(getDummyList())
//
//        viewModel.userDetails.observe(viewLifecycleOwner, Observer { user ->
//            when (user) {
//                is DataState.Success -> {
//                    binding.username.text = user.data.fullName
//                    binding.profileIcon.load(user.data.imageUrl) {
//                        crossfade(true)
//                        placeholder(R.drawable.ic_profile_placeholder)
//                        transformations(CircleCropTransformation())
//                        error(R.drawable.ic_profile_placeholder)
//                    }
//                }
//            }
//        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.settings_menu, menu)
    }

    private fun getDummyList(): List<AchievementItem> = List(8) { AchievementItem(R.drawable.ic_round_stars_24, "Baby Steps", "Completed your first lesson") }
}