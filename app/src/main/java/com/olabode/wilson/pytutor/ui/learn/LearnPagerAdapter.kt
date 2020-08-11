package com.olabode.wilson.pytutor.ui.learn

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.olabode.wilson.pytutor.ui.learn.advanced.AdvancedFragment
import com.olabode.wilson.pytutor.ui.learn.basic.BasicFragment

/**
 *   Created by OLABODE WILSON on 7/11/20.
 */

private const val NUM_PAGES = 2

class LearnPagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BasicFragment()
            else -> {
                AdvancedFragment()
            }
        }
    }

}