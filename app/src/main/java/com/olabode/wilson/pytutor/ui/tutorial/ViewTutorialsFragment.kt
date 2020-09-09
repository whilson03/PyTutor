package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentViewTutorialsBinding
import com.olabode.wilson.pytutor.extensions.viewBinding


class ViewTutorialsFragment : Fragment(R.layout.fragment_view_tutorials) {

    private val binding by viewBinding(FragmentViewTutorialsBinding::bind)
    private lateinit var pagesAdapter: TutorialPageAdapter
    private lateinit var viewPager: ViewPager2
    var currentPosition: Int = DEFAULT_PAGE_POSITION


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val topic = ViewTutorialsFragmentArgs.fromBundle(requireArguments()).topic
        val totalNoOfPages = topic.noOfPages
        setUpPageCounter(totalNoOfPages)
        pagesAdapter = TutorialPageAdapter(this, totalNoOfPages)
        viewPager = binding.lessonViewPager
        viewPager.adapter = pagesAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == totalNoOfPages - 1) {
                    binding.nextPage.text = getString(R.string.finish)
                } else {
                    binding.nextPage.text = getString(R.string.next)
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
                    if (currentPosition == totalNoOfPages - 1) {
                        binding.nextPage.text = getString(R.string.finish)
                    }
                }
                else -> {
                    Toast.makeText(requireContext(), "NAVIGATE", Toast.LENGTH_SHORT).show()
                    // finish
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

    companion object {
        const val DEFAULT_PAGE_POSITION = 0
    }
}