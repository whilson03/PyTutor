package com.olabode.wilson.pytutor.ui.tutorial.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.olabode.wilson.pytutor.models.tutorial.LessonResponse
import com.olabode.wilson.pytutor.ui.tutorial.TutorialPageFragment

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
class TutorialPageAdapter(fragment: Fragment, private val pages: Int, val list: List<LessonResponse>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = pages

    override fun createFragment(position: Int): Fragment {
        return TutorialPageFragment.newInstance(list[position])
    }
}
