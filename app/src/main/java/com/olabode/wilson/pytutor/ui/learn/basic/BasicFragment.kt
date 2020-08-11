package com.olabode.wilson.pytutor.ui.learn.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.olabode.wilson.pytutor.databinding.FragmentBasicBinding
import com.olabode.wilson.pytutor.interfaces.OnItemClickListener
import com.olabode.wilson.pytutor.models.Tutorial
import com.olabode.wilson.pytutor.ui.learn.TutorialsRecyclerAdapter
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


}