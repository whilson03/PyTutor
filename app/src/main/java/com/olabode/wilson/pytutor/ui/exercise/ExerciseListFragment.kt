package com.olabode.wilson.pytutor.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentExerciseListBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ogheneruona Onobrakpeya on 10/10/20.
 */

@AndroidEntryPoint
class ExerciseListFragment : Fragment(R.layout.fragment_exercise_list) {
    private val binding by viewBinding(FragmentExerciseListBinding::bind)
    private val viewModel: ExercisesViewModel by viewModels()
    private lateinit var adapter: ExerciseListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ExerciseListAdapter {exercise ->
            findNavController().
            navigate(ExerciseListFragmentDirections.actionExerciseListFragmentToExerciseFragment(exercise))
        }

        binding.exerciseListRecycler.adapter = adapter
//        binding.progressBar.isVisible = false
//        binding.exerciseListRecycler.isVisible = true
//        adapter.submitList(getDummyList().sorted())
        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.exercises.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.noInternetState.root.isVisible = false
                }

                is DataState.Success -> {
                    binding.progressBar.isVisible = false
                    binding.mainPage.isVisible = true
                    binding.noInternetState.root.isVisible = false
                    adapter.submitList(result.data.sorted())
                }

                is DataState.Error -> {
                    binding.progressBar.isVisible = false
                    binding.noInternetState.root.isVisible = true
                    binding.mainPage.isVisible = false
                }
            }
        })
    }

//    fun getDummyList() : List<Exercise> {
//        return listOf(
//                Exercise("1", "Palindrome check", "Hard", "Write a program which checks if a word is a palindrome.", "def palindrome(word):\n" +
//                        "    left = 0\n" +
//                        "    right = len(word) - 1\n" +
//                        "\n" +
//                        "    while left < right:\n" +
//                        "        if word[left] != word[right]:\n" +
//                        "            return False\n" +
//                        "        left += 1\n" +
//                        "        right -= 1\n" +
//                        "\n" +
//                        "    return True\n" +
//                        "\n" +
//                        "def main():\n" +
//                        "    word = input(\"Enter a word\\n\")\n" +
//                        "\n" +
//                        "    if palindrome(word):\n" +
//                        "        print(f\"{word} is a palindrome\")\n" +
//                        "    else:\n" +
//                        "        print(f\"{word} is not a palindrome\")\n" +
//                        "\n" +
//                        "main()"),
//                Exercise("1", "Subtracting", "Medium", "Subtract These", "Add Add"),
//                Exercise("1", "Dividing", "Hard", "Divide These", "Add Add")
//        )
//    }
}