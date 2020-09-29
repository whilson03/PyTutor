package com.olabode.wilson.pytutor.ui.algos

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentAlgorithmBinding
import com.olabode.wilson.pytutor.extensions.viewBinding

class AlgorithmFragment : Fragment(R.layout.fragment_algorithm) {

    private val binding by viewBinding(FragmentAlgorithmBinding::bind)
    private val args: AlgorithmFragmentArgs by navArgs()

}