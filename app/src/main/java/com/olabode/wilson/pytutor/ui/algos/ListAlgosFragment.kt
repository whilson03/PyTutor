package com.olabode.wilson.pytutor.ui.algos

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentListAlgosBinding
import com.olabode.wilson.pytutor.extensions.viewBinding

class ListAlgosFragment : Fragment(R.layout.fragment_list_algos) {

    private val binding by viewBinding(FragmentListAlgosBinding::bind)
    private lateinit var adapter: AlgorithmListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AlgorithmListAdapter { algorithm ->
            findNavController().navigate(ListAlgosFragmentDirections
                    .actionListAlgosFragmentToAlgorithmFragment(algorithm))
        }
        binding.algoList.adapter = adapter
    }

}