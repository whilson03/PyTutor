package com.olabode.wilson.pytutor.ui.tutorial

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentAllLessonsCompletedBinding
import com.olabode.wilson.pytutor.extensions.navigateSafe
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.ui.tutorial.viewmodel.AllLessonCompletedViewModel
import com.olabode.wilson.pytutor.utils.Utils
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size
import timber.log.Timber

/**
 * Created by Ogheneruona Onobrakpeya on 11/1/20.
 */
@AndroidEntryPoint
class AllLessonsCompletedFragment : Fragment(R.layout.fragment_all_lessons_completed) {
    private val binding by viewBinding(FragmentAllLessonsCompletedBinding::bind)
    private val viewModel: AllLessonCompletedViewModel by viewModels()
    private val args: AllLessonsCompletedFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topic = args.lastTopic
        val score = args.score
        val numberOfQuestions = args.numberOfQuestions
        showConfetti()

        binding.home.setOnClickListener {
            navigateSafe(AllLessonsCompletedFragmentDirections
                    .actionAllLessonsCompletedFragmentToHomeFragment())
        }

        val scoreRating = Utils.calculateRating(score.toFloat(), numberOfQuestions.toFloat())
        viewModel.onLastTopicCompleted(topic.topicId, scoreRating, topic.nextTopicsId)
                .observe(viewLifecycleOwner, Observer {
                    when (it) {
                        is DataState.Success -> Timber.d("SUCCESS")
                        else -> { /* no-op */
                        }
                    }
                })

    }

    private fun showConfetti() {
        val width = Utils.getWidth(requireContext(), requireActivity())
        binding.viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square, Shape.Circle)
                .addSizes(Size(12))
                .setPosition(-50f, width + 50f, -50f, -50f)
                .streamFor(300, 2000L)

    }
}