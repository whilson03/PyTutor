package com.olabode.wilson.pytutor.ui.learn.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EdgeEffect
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.olabode.wilson.pytutor.databinding.FragmentBasicBinding
import com.olabode.wilson.pytutor.interfaces.OnItemClickListener
import com.olabode.wilson.pytutor.models.Tutorial
import com.olabode.wilson.pytutor.ui.learn.TutorialsRecyclerAdapter
import com.olabode.wilson.pytutor.utils.Constants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BasicFragment : Fragment() {

    private val viewModel: BasicViewModel by viewModels()

    private var _binding: FragmentBasicBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: TutorialsRecyclerAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentBasicBinding.inflate(inflater, container, false)
        adapter = TutorialsRecyclerAdapter()
        binding.basicRecyclerview.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.basicTutorials.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(listOf(
                        Tutorial(
                                1, "Intro", "welcome to learn python programming", false, 80, 1, true
                        ), Tutorial(
                        2, "Intro", "welcome to learn python programming", true, 80, 2, true
                ), Tutorial(
                        3, "Intro", "welcome to learn python programming", true, 80, 3, true
                ), Tutorial(
                        4, "Intro", "welcome to learn python programming", true, 80, 4, true
                ), Tutorial(
                        5, "Intro", "welcome to learn python programming", true, 0, 5, true
                ), Tutorial(
                        6, "Intro", "welcome to learn python programming", true, 0, 6, true
                ), Tutorial(
                        7, "Intro", "welcome to learn python programming", true, 80, 1, true
                ), Tutorial(
                        8, "Intro", "welcome to learn python programming", true, 80, 1, true
                ), Tutorial(
                        9, "Intro", "welcome to learn python programming", true, 80, 1, true
                ), Tutorial(
                        10, "Intro", "welcome to learn python programming", true, 80, 1, true
                )
                ))
            }
            setupRecyclerViewAnimations(binding.basicRecyclerview)
        })

        adapter.setOntutorialClickedListener(object : OnItemClickListener<Tutorial> {
            override fun onClick(t: Tutorial) {
                Toast.makeText(requireContext(), t.topic, Toast.LENGTH_SHORT).show()
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setupRecyclerViewAnimations(it: RecyclerView) {
        it.edgeEffectFactory = object : RecyclerView.EdgeEffectFactory() {
            override fun createEdgeEffect(view: RecyclerView, direction: Int): EdgeEffect {
                return object : EdgeEffect(view.context) {

                    override fun onPull(deltaDistance: Float) {
                        super.onPull(deltaDistance)
                        handlePull(deltaDistance)
                    }

                    override fun onPull(deltaDistance: Float, displacement: Float) {
                        super.onPull(deltaDistance, displacement)
                        handlePull(deltaDistance)
                    }

                    private fun handlePull(deltaDistance: Float) {
                        // This is called on every touch event while the list is scrolled with a finger.
                        // We simply update the view properties without animation.
                        val sign = if (direction == DIRECTION_BOTTOM) -1 else 1
                        val rotationDelta =
                                sign * deltaDistance * Constants.OVERSCROLL_ROTATION_MAGNITUDE
                        val translationYDelta =
                                sign * view.width * deltaDistance * Constants.OVERSCROLL_TRANSLATION_MAGNITUDE
                        view.forEachVisibleHolder { holder: TutorialsRecyclerAdapter.TutorialViewHolder ->
                            holder.rotation.cancel()
                            holder.translationY.cancel()
                            holder.itemView.rotation += rotationDelta
                            holder.itemView.translationY += translationYDelta
                        }
                    }

                    override fun onRelease() {
                        super.onRelease()
                        // The finger is lifted. This is when we should start the animations to bring
                        // the view property values back to their resting states.
                        view.forEachVisibleHolder { holder: TutorialsRecyclerAdapter.TutorialViewHolder ->
                            holder.rotation.start()
                            holder.translationY.start()
                        }
                    }

                    override fun onAbsorb(velocity: Int) {
                        super.onAbsorb(velocity)
                        val sign = if (direction == DIRECTION_BOTTOM) -1 else 1
                        // The list has reached the edge on fling.
                        val translationVelocity =
                                sign * velocity * Constants.FLING_TRANSLATION_MAGNITUDE
                        view.forEachVisibleHolder { holder: TutorialsRecyclerAdapter.TutorialViewHolder ->
                            holder.translationY
                                    .setStartVelocity(translationVelocity)
                                    .start()
                        }
                    }
                }
            }
        }

        it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                recyclerView.forEachVisibleHolder { holder: TutorialsRecyclerAdapter.TutorialViewHolder ->
                    holder.rotation
                            // Update the velocity.
                            // The velocity is calculated by the vertical scroll offset.
                            .setStartVelocity(holder.currentVelocity - dx * Constants.SCROLL_ROTATION_MAGNITUDE)
                            // Start the animation. This does nothing if the animation is already running.
                            .start()
                }
            }
        })
    }

    inline fun <reified T : RecyclerView.ViewHolder> RecyclerView.forEachVisibleHolder(
            action: (T) -> Unit
    ) {
        for (i in 0 until childCount) {
            action(getChildViewHolder(getChildAt(i)) as T)
        }
    }


}