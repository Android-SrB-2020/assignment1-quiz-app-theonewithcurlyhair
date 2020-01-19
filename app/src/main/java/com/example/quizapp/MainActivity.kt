package com.example.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Author : Nikita Mieshalnykov
 * Task : Assignment 01
 */

class MainActivity : AppCompatActivity() {

    lateinit var label: TextView
    private var index: Int = 0
    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )
    private var currentQuestion: Question = questionBank[index]


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        label = findViewById(R.id.lbl)
        setQuestionTxt()


        //Setting buttons and clickHandlers

        var trueButton: Button = findViewById(R.id.button_true)
        var falseButton: Button = findViewById(R.id.button_false)
        var nextButton: Button = findViewById(R.id.button_next)
        var previousButton: Button = findViewById(R.id.button_prev)


        nextButton.setOnClickListener { nextQuestion() }
        previousButton.setOnClickListener { prevQuestion() }
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
    }

    /**
     * Gets next question
     * If out of range starts from the first one
     */
    private fun nextQuestion() {
        if (index != questionBank.size - 1) {
            index++
        } else {
            index = 0
        }
        currentQuestion = questionBank[index]
        setQuestionTxt()
    }

    /**
     * Gets prev question
     * If out of range starts from the last one
     */
    private fun prevQuestion() {
        if (index != 0) {
            index--
        } else {
            index = questionBank.size - 1
        }
        currentQuestion = questionBank[index]
        setQuestionTxt()
    }

    /**
     * Sets question text according to the current question
     */
    private fun setQuestionTxt() {
        label.setText(currentQuestion.questionId)
    }

    /**
     * Checks users input and question answer
     * Shows toast with the result
     */
    private fun checkAnswer(inAnswer: Boolean) {
        var msg = ""
        if (inAnswer == currentQuestion.answer) {
            msg = "Your answer is CORRECT!"
        } else {
            msg = "Your answer is WRONG!"
        }
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }


}
