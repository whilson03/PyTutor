package com.olabode.wilson.pytutor.ui.profile

import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentProfileBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel: ProfileViewModel by activityViewModels()


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.settings_menu, menu)
    }

}