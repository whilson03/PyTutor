package com.olabode.wilson.pytutor.ui.code

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentInterpreterBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.views.PythonSyntaxManager
import kotlin.math.max
import kotlin.math.min


class InterpreterFragment : Fragment(R.layout.fragment_interpreter) {

    private val binding by viewBinding(FragmentInterpreterBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAutoComplete()
        PythonSyntaxManager.applyMonokaiTheme(context, binding.editor)

        binding.keysOption.runCode.setOnClickListener {
            val code = binding.editor.text.toString()
            executeCode(code)
        }

        binding.keysOption.insertTab.setOnClickListener {
            insertTab()
        }

        binding.toolbar2.setNavigationOnClickListener { findNavController().navigateUp() }
    }

    private fun insertTab() {
        val start = max(binding.editor.selectionStart, 0)
        val end = max(binding.editor.selectionEnd, 0)
        binding.editor.text.replace(min(start, end), max(start, end),
                "\t", 0, "\t".length)
    }

    private fun executeCode(code: String) {
        CodeOutputFragment(code).show(parentFragmentManager, "CodeSheet")
    }


    private fun setUpAutoComplete() {
        val keywords: Array<String> = resources.getStringArray(R.array.python_keywords)
        val suggestionLayout = R.layout.item_suggestions

        val viewId: Int = R.id.suggestItemTextView
        val adapter: ArrayAdapter<String> = ArrayAdapter(requireContext(), suggestionLayout, viewId,
                keywords)
        binding.editor.setAdapter(adapter)
    }
}