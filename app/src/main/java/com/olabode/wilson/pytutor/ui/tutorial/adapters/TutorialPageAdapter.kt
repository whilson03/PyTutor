package com.olabode.wilson.pytutor.ui.tutorial.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.ui.tutorial.QuestionFragment
import com.olabode.wilson.pytutor.ui.tutorial.TutorialPageFragment

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
class TutorialPageAdapter(
        fragment: Fragment,
        private val pages: Int,
        val list: List<Lesson>,
        val topic: Topic
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = pages

    override fun createFragment(position: Int): Fragment {
        val response = list[position]
        return when (response.type) {
            LessonResponseType.LESSON.ordinal -> TutorialPageFragment.newInstance(response)
            else -> QuestionFragment.newInstance(response, topic)
        }
    }
}
