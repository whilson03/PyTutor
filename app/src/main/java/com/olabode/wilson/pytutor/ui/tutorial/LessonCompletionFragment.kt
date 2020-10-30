package com.olabode.wilson.pytutor.ui.tutorial

import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentLessonCompletionBinding
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.showAndAnimateRating
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.ui.tutorial.viewmodel.CompletedLessonViewModel
import com.olabode.wilson.pytutor.utils.Utils
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size
import timber.log.Timber

@AndroidEntryPoint
class LessonCompletionFragment : Fragment(R.layout.fragment_lesson_completion) {
    private val binding by viewBinding(FragmentLessonCompletionBinding::bind)

    private val args: LessonCompletionFragmentArgs by navArgs()
    private val viewModel: CompletedLessonViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val score = args.score
        val numberOfQuestions = args.numberOfQuestions
        val topic = args.topic
        showConfetti()

        val scoreRating = Utils.calculateRating(score.toFloat(), numberOfQuestions.toFloat())
        binding.ratingBar.showAndAnimateRating(scoreRating)

        viewModel.onCourseCompleted(topic.topicId, scoreRating, topic.nextTopicsId)
                .observe(viewLifecycleOwner, Observer {
                    when (it) {
                        is DataState.Success -> Timber.d("SUCCESS")
                        else -> { /* no-op */
                        }
                    }
                })


        isNextTopicAvailable(topic)



        binding.home.setOnClickListener {
            findNavController().popBackStack()
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

    private fun isNextTopicAvailable(topic: Topic) {
        if (!topic.isLastTopic) {
            topic.nextTopicsId?.let { nextTopicId ->
                viewModel.getNextTopic(nextTopicId).observe(viewLifecycleOwner, Observer { result ->
                    when (result) {
                        is DataState.Success -> {
                            binding.nextLesson.show()
                            binding.nextLesson.setOnClickListener { navigateToNext(result.data) }
                        }
                        is DataState.Error -> {
                            binding.nextLesson.hide()
                        }
                        is DataState.Loading -> {
                            binding.nextLesson.hide()
                        }
                    }
                })
            }
        }
    }

    private fun navigateToNext(topic: Topic) {
        findNavController().navigate(LessonCompletionFragmentDirections
                .actionLessonCompletionFragmentToLessonGraph(topic.title, topic)
        )
    }

}