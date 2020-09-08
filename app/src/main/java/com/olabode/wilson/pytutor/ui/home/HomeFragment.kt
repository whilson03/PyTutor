package com.olabode.wilson.pytutor.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentHomeBinding
import com.olabode.wilson.pytutor.models.HomeListItem
import com.olabode.wilson.pytutor.utils.AuthResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter: HomeListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        adapter = HomeListAdapter { }
        binding.homeRecycler.adapter = adapter
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAuthState()
        adapter.submitList(dummyList())
    }

    private fun dummyList(): List<HomeListItem>? =
            listOf(
                    HomeListItem(1, R.drawable.ic_profile, "Tutorial"),
                    HomeListItem(1, R.drawable.ic_profile, "Examples"),
                    HomeListItem(1, R.drawable.ic_profile, "Questions"),
                    HomeListItem(1, R.drawable.ic_profile, "Code")
            )


    private fun observeAuthState() {
        viewModel.userStatus.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is AuthResult.Failed -> {
                    findNavController()
                            .navigate(HomeFragmentDirections.actionHomeFragmentToAuthNavigation())
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

