package com.zenith.quizapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.zenith.quizapp.databinding.ActivityMainBinding
import com.zenith.quizapp.model.Question
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val noteViewModel: MainViewModel by viewModels()
    private var questionCounter: Int = 0
    private var questionTotalCount: Int = 0
    private lateinit var currentQuestion: Question
    private lateinit var questionList: List<Question>
    private var correctOption: Int = 0

    companion object {
        private const val TAG = "MainActivity"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteViewModel.getAllQuestions().observe(this, Observer {
            questionTotalCount = it.size
            questionList = it
            onOptionsClicked()
        })
    }

    private fun onOptionsClicked() {
        setNextQuestion()
        binding.btnOptionOne.setOnClickListener {
            val optionOne = selectedButton(1)
            if (optionOne == correctOption) {
                setNextQuestion()
            }
        }
        binding.btnOptionTwo.setOnClickListener {
            val optionTwo = selectedButton(2)
            if (optionTwo == correctOption) {
                setNextQuestion()
            }
        }
        binding.btnOptionThree.setOnClickListener {
            val optionThree = selectedButton(3)
            if (optionThree == correctOption) {
                setNextQuestion()
            }
        }
        binding.btnOptionFour.setOnClickListener {
            val optionFour = selectedButton(4)
            if (optionFour == correctOption) {
                setNextQuestion()
            }
        }
    }

    private fun setNextQuestion() {
        if (questionCounter < questionTotalCount) {
            currentQuestion = questionList[questionCounter]

            binding.tvQuestion.text = currentQuestion.question
            binding.btnOptionOne.text = currentQuestion.optionOne
            binding.btnOptionTwo.text = currentQuestion.optionTwo
            binding.btnOptionThree.text = currentQuestion.optionThree
            binding.btnOptionFour.text = currentQuestion.optionFour
            correctOption = currentQuestion.correctAnswer
            questionCounter++
        } else {
            finish()
        }

    }

    private fun selectedButton(buttonSelected: Int): Int {
        return buttonSelected
    }
}