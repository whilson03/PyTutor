package com.olabode.wilson.pytutor.ui.tutorial

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentLessonCompletionBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size


class LessonCompletionFragment : Fragment(R.layout.fragment_lesson_completion) {
    private val binding by viewBinding(FragmentLessonCompletionBinding::bind)

    private val args: LessonCompletionFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val display = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(display)
        val score = args.score
        val numberOfQuestions = args.numberOfQuestions

        binding.viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square, Shape.Circle)
                .addSizes(Size(12))
                .setPosition(-50f, display.widthPixels + 50f, -50f, -50f)
                .streamFor(300, 5000L)


        binding.home.setOnClickListener {
            findNavController().popBackStack()
        }

        val scoreRating = getRating(score.toFloat(), numberOfQuestions.toFloat())
        setUpRating(scoreRating)
    }

    private fun setUpRating(value: Float) {
        val current: Float = binding.ratingBar.rating
        val anim = ObjectAnimator.ofFloat(binding.ratingBar, "rating", current, value)
        anim.duration = 2000
        anim.start()
    }

    private fun getRating(score: Float, numberOfQuestions: Float): Float {
        // Convert score to star rating
        val maxRating = NO_STARS
        return maxRating / numberOfQuestions * score
    }

    companion object {
        const val NO_STARS = 3
    }
}