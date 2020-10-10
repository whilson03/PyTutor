package com.olabode.wilson.pytutor.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentExerciseContentBinding
import com.olabode.wilson.pytutor.extensions.viewBinding

/**
 * Created by Ogheneruona Onobrakpeya on 10/10/20.
 */
class ExerciseFragment: Fragment(R.layout.fragment_exercise_content) {
    private val binding by viewBinding(FragmentExerciseContentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}