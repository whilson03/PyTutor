package com.olabode.wilson.pytutor.ui.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentLearnBinding

class LearnFragment : Fragment() {

    private var _binding: FragmentLearnBinding? = null
    private val binding get() = _binding!!
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentLearnBinding.inflate(inflater, container, false)

        tabLayout = binding.tabLayout
        binding.pager.adapter = LearnPagerAdapter(this)
        TabLayoutMediator(tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.basic)
                else -> tab.text = getString(R.string.advanced)
            }
        }.attach()


        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}