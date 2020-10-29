package com.olabode.wilson.pytutor.ui.onboarding

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentOnBoardingBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.IntroSlideItem
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {

    private lateinit var adapter: OnboardingAdapter

    private val binding by viewBinding(FragmentOnBoardingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OnboardingAdapter(onBoardingItems())
        binding.introSliderViewPager.adapter = adapter
        setupIndicators()
        setCurrentIndicator(index = 0)
        binding.introSliderViewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(index = position)
            }
        })

        binding.next.setOnClickListener {
            if (binding.introSliderViewPager.currentItem + 1 < adapter.itemCount) {
                binding.introSliderViewPager.currentItem += 1
            } else {
                navigateToLogin()
            }
        }

        binding.skipOnboarding.setOnClickListener {
            navigateToLogin()
        }

    }


    private fun onBoardingItems(): List<IntroSlideItem> {
        return listOf(
                IntroSlideItem(
                        "Learn On the GO!",
                        "Not earth or space, realize the faith.The surrender is an evil self.",
                        R.drawable.ic_coder_girl
                ),
                IntroSlideItem(
                        "You have to wrestle",
                        "Not earth or space, realize the faith.The surrender is an evil self.",
                        R.drawable.ic_programmer
                ),
                IntroSlideItem(
                        "You have to wrestle",
                        "Not earth or space, realize the faith.The surrender is an evil self.",
                        R.drawable.ic_coder_robot
                )
        )
    }


    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(requireContext())
            indicators[i].apply {
                this?.setImageDrawable(
                        ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.onboarding_indicator_inactive
                        )
                )

                this?.layoutParams = layoutParams
            }
            binding.indicatorContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = binding.indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.onboarding_indicator_active
                        )
                )
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.onboarding_indicator_inactive
                        )
                )
            }

        }
    }

    private fun navigateToLogin() {
        findNavController().navigate(OnBoardingFragmentDirections
                .actionOnBoardingFragmentToAuthNavigation())
    }

    private fun updateText() {
        binding.next.text = resources.getString(R.string.finish)
    }

}