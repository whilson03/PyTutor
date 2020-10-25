package com.olabode.wilson.pytutor.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.SlideItemContainerBinding
import com.olabode.wilson.pytutor.models.IntroSlideItem
import com.olabode.wilson.pytutor.ui.onboarding.OnboardingAdapter.OnBoardingViewHolder

/**
 *   Created by OLABODE WILSON on 10/25/20.
 */

class OnboardingAdapter(private val sliderItems: List<IntroSlideItem>) :
        RecyclerView.Adapter<OnBoardingViewHolder>() {


    class OnBoardingViewHolder(private val binding: SlideItemContainerBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(introSlideItem: IntroSlideItem) {
            binding.sliderTitle.text = introSlideItem.title
            binding.sliderTextDescription.text = introSlideItem.description
            binding.sliderImage.setImageResource(introSlideItem.icon)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val binding = SlideItemContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnBoardingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return sliderItems.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(sliderItems[position])
    }
}