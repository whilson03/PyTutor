package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentQuestionBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.models.tutorial.Question
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class QuestionFragment : Fragment(R.layout.fragment_question) {
    private val binding by viewBinding(FragmentQuestionBinding::bind)
    private lateinit var lessonQuestionResponse: Lesson
    private var currentQuestionIndex = 0
    private var isQuizAnswered = false
    private var score = 0
    private var answeredKeys = ArrayList<String>()
    private lateinit var topic: Topic

    companion object {
        const val QUESTION_RESPONSE = "QuestionResponse"
        const val KEY_SAVE_QUESTIONS = "QUESTIONS"
        const val KEY_CURRENT_INDEX = "KEY_CURRENT_INDEX"
        const val KEY_COMPLETED_QUIZ = "KEY_COMPLETED_QUIZ"
        const val KEY_SCORE = "SCORE"
        const val LIST_OF_KEYS_ANSWERED = "LIST_OF_KEYS_ANSWERED"
        const val TOPIC = "TOPIC"

        @JvmStatic
        fun newInstance(lesson: Lesson, topic: Topic) =
            QuestionFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(QUESTION_RESPONSE, lesson)
                    putParcelable(TOPIC, topic)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            arguments?.let {
                lessonQuestionResponse = it.getParcelable(QUESTION_RESPONSE)!!
                topic = it.getParcelable(TOPIC)!!
            }
        } else {
            lessonQuestionResponse = savedInstanceState.getParcelable(KEY_SAVE_QUESTIONS)!!
            currentQuestionIndex = savedInstanceState.getInt(KEY_CURRENT_INDEX)
            score = savedInstanceState.getInt(KEY_SCORE)
            isQuizAnswered = savedInstanceState.getBoolean(KEY_COMPLETED_QUIZ)
            answeredKeys = savedInstanceState.getStringArrayList(LIST_OF_KEYS_ANSWERED)!!
            topic = savedInstanceState.getParcelable(TOPIC)!!
        }

        val questions = lessonQuestionResponse.question!!.values.toList()

        setUpQuestion(questions[currentQuestionIndex])

        if (answeredKeys.contains(questions[currentQuestionIndex].question)) {
            isQuizAnswered = true

            getTextFromCheckedId(binding.optionsGroup.checkedRadioButtonId)
            val question = questions[currentQuestionIndex]
            val optionsMap = question.options
            showRightAndWrongAnswers(optionsMap[question.answerKey] ?: error(""))
            binding.submitOrNext.text = getString(R.string.next)
            disableOptions()
        }

        binding.submitOrNext.setOnClickListener {
            if (getString(R.string.finish) != binding.submitOrNext.text.toString()) {
                if (getString(R.string.next) == binding.submitOrNext.text.toString()) {
                    moveToNextQuestion(questions)
                    setUpQuestion(questions[currentQuestionIndex])
                    resetOptions()
                    enableOptions()
                    binding.submitOrNext.text = getString(R.string.submit)
                } else {
                    if (binding.option1.isChecked || binding.option2.isChecked
                        || binding.option3.isChecked
                    ) {

                        val selectedAnswer =
                            getTextFromCheckedId(binding.optionsGroup.checkedRadioButtonId)
                        validateAnswer(
                            selectedAnswer,
                            questions[currentQuestionIndex]
                        )
                        answeredKeys.add(questions[currentQuestionIndex].question)

                        if (currentQuestionIndex == questions.size.minus(1)) {
                            navigateToCompletionScreen(score, noOfQuestion = questions.size)
                        } else {
                            binding.submitOrNext.text = getString(R.string.next)
                        }
                        disableOptions()
                    } else {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.pick_option_prompt),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else {
                navigateToCompletionScreen(score, questions.size)
            }
        }
    }

    private fun navigateToCompletionScreen(score: Int, noOfQuestion: Int) {
        findNavController().navigate(
            ViewTutorialsFragmentDirections
                .actionViewTutorialsFragmentToLessonCompletionFragment(
                    score = score, numberOfQuestions = noOfQuestion,
                    topic = topic
                )
        )
    }

    private fun setUpQuestion(question: Question) {
        val options = question.options.values.toList()
        binding.questionText.text = question.question
        binding.option1.text = options[0]
        binding.option2.text = options[1]
        binding.option3.text = options[2]
    }

    private fun moveToNextQuestion(questions: List<Question>) {
        if (currentQuestionIndex < questions.size.minus(1)) {
            currentQuestionIndex++
        }
    }

    private fun validateAnswer(answer: String, question: Question) {
        val optionsMap = question.options
        showRightAndWrongAnswers(optionsMap[question.answerKey] ?: error(""))

        if (optionsMap[question.answerKey] == answer) {
            score++
        }
    }

    private fun getTextFromCheckedId(id: Int): String {
        return when (id) {
            binding.option1.id -> binding.option1.text.toString()
            binding.option2.id -> binding.option2.text.toString()
            else -> binding.option3.text.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_CURRENT_INDEX, currentQuestionIndex)
        outState.putParcelable(KEY_SAVE_QUESTIONS, lessonQuestionResponse)
        outState.putBoolean(KEY_COMPLETED_QUIZ, isQuizAnswered)
        outState.putInt(KEY_SCORE, score)
        outState.putStringArrayList(LIST_OF_KEYS_ANSWERED, answeredKeys)
        outState.putParcelable(TOPIC, topic)
    }

    private fun enableOptions() {
        binding.optionsGroup.clearCheck()
        binding.option1.isEnabled = true
        binding.option2.isEnabled = true
        binding.option3.isEnabled = true
    }

    private fun disableOptions() {
        binding.option1.isEnabled = false
        binding.option2.isEnabled = false
        binding.option3.isEnabled = false
    }

    private fun showRightAndWrongAnswers(answer: String) {
        for (i in 0 until binding.optionsGroup.childCount) {
            val rb = binding.optionsGroup.getChildAt(i) as RadioButton
            if (rb.text.toString() == answer) {
                rb.setBackgroundResource(R.drawable.option_correct_background)
            } else {
                rb.setBackgroundResource(R.drawable.option_wrong_background)
            }
        }
    }

    private fun resetOptions() {
        for (i in 0 until binding.optionsGroup.childCount) {
            val rb = binding.optionsGroup.getChildAt(i) as RadioButton
            rb.setBackgroundResource(R.drawable.quiz_options_selector)
        }
    }
}