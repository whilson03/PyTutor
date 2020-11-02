package com.olabode.wilson.pytutor.ui.tutorial

import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.Fragment
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentAllLessonsCompletedBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.utils.navigateSafe
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size

/**
 * Created by Ogheneruona Onobrakpeya on 11/1/20.
 */

class AllLessonsCompletedFragment : Fragment(R.layout.fragment_all_lessons_completed) {
    private val binding by viewBinding(FragmentAllLessonsCompletedBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showConfetti()

        binding.home.setOnClickListener {
            navigateSafe(AllLessonsCompletedFragmentDirections
                    .actionAllLessonsCompletedFragmentToHomeFragment())
        }
    }

    private fun showConfetti() {
        val display = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(display)
        binding.viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square, Shape.Circle)
                .addSizes(Size(12))
                .setPosition(-50f, display.widthPixels + 50f, -50f, -50f)
                .streamFor(300, 2000L)
    }
}