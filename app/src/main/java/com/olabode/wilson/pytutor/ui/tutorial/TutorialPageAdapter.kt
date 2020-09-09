package com.olabode.wilson.pytutor.ui.tutorial

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
class TutorialPageAdapter(fragment: Fragment, private val pages: Int) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = pages

    override fun createFragment(position: Int): Fragment {
        return TutorialPageFragment()
    }
}
