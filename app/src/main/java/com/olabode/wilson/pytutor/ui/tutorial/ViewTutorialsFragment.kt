package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentViewTutorialsBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.ui.tutorial.adapters.TutorialPageAdapter
import com.olabode.wilson.pytutor.ui.tutorial.viewmodel.TutorialLessonViewModel
import com.olabode.wilson.pytutor.utils.EventObserver
import com.olabode.wilson.pytutor.utils.LoadingState
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewTutorialsFragment : Fragment(R.layout.fragment_view_tutorials) {

    private val binding by viewBinding(FragmentViewTutorialsBinding::bind)
    private val viewModel: TutorialLessonViewModel
        by navGraphViewModels(R.id.lesson_graph) { defaultViewModelProviderFactory }

    private val arg: ViewTutorialsFragmentArgs by navArgs()

    private lateinit var pagesAdapter: TutorialPageAdapter
    private lateinit var viewPager: ViewPager2
    var currentPosition: Int = DEFAULT_PAGE_POSITION

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val topic = arg.topic
        val title = arg.title
        val totalNoOfPages = topic.noOfPages
        setUpPageCounter(totalNoOfPages)
        binding.toolbar.title = title

        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }

        viewModel.showProgressBar.observe(viewLifecycleOwner, EventObserver { state ->
            when (state) {
                is LoadingState.Loading -> binding.progressBar.isVisible = true
                is LoadingState.LoadingComplete -> binding.progressBar.isVisible = false
            }
        })
        setupUI(topic, totalNoOfPages)
    }

    private fun setupUI(topic: Topic, totalNoOfPages: Int) {
        viewModel.getLessons(topic.topicId).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.noInternetState.root.isVisible = false
                }

                is DataState.Success -> {
                    binding.noInternetState.root.isVisible = false
                    binding.progressBar.isVisible = false
                    doOnSuccess(totalNoOfPages, result.data.sortedBy { it.page }, topic)
                }
                is DataState.Error -> {
                    binding.noInternetState.root.isVisible = true
                    binding.progressBar.isVisible = false
                    showPersistentSnackBar(result.message) {
                        setupUI(topic, totalNoOfPages)
                    }
                }
            }
        })
    }

    private fun doOnSuccess(totalNoOfPages: Int, lessons: List<Lesson>, topic: Topic) {
        pagesAdapter = TutorialPageAdapter(
            this,
            totalNoOfPages,
            lessons,
            topic = topic
        )
        viewPager = binding.lessonViewPager
        viewPager.adapter = pagesAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == totalNoOfPages - 1) {
                    binding.nextPage.visibility = View.INVISIBLE
                } else {
                    binding.nextPage.text = getString(R.string.next)
                    binding.nextPage.isVisible = true
                }
                currentPosition = position
                setCurrentIndicator(index = position)
            }
        })

        binding.nextPage.setOnClickListener {
            when {
                currentPosition < totalNoOfPages - 1 -> {
                    currentPosition++
                    viewPager.currentItem = currentPosition
                }
            }
        }

        binding.previousPage.setOnClickListener {
            if (currentPosition > DEFAULT_PAGE_POSITION) {
                binding.nextPage.text = getString(R.string.next)
                currentPosition--
                viewPager.currentItem = currentPosition
            }
        }
    }

    private fun setUpPageCounter(noOfPages: Int) {
        val indicators = arrayOfNulls<ImageView>(noOfPages)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(4, 0, 4, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(requireContext())
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.unread_pages_indicator
                    )
                )

                this?.layoutParams = layoutParams
            }
            binding.indicatorLayout.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = binding.indicatorLayout.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorLayout[i] as ImageView
            if (i <= index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.viewed_page_indicator
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.unread_pages_indicator
                    )
                )
            }
        }
    }

    private fun showPersistentSnackBar(message: String, action: () -> Unit) {
        Snackbar.make(binding.coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE)
            .setAction(getString(R.string.retry)) {
                action.invoke()
            }.show()
    }

    companion object {
        const val DEFAULT_PAGE_POSITION = 0
    }
}