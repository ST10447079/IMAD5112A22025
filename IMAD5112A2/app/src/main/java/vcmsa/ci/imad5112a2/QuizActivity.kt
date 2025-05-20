package com.example.flashcardquiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcardquiz.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "The Great Wall of China is visible from the moon.",
        "World War I ended in 1918.",
        "The Roman Empire fell in 476 AD.",
        "Mahatma Gandhi was born in South Africa."
    )

    private val answers = arrayOf(true, false, true, true, false)

    private var currentIndex = 0
    private var score = 0
    private var userAnswers = BooleanArray(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showQuestion()

        binding.btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        binding.btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        binding.btnNext.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                showQuestion()
                binding.txtFeedback.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("answers", answers)
                intent.putExtra("questions", questions)
                intent.putExtra("userAnswers", userAnswers)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun showQuestion() {
        binding.txtQuestion.text = questions[currentIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correct = answers[currentIndex]
        userAnswers[currentIndex] = userAnswer
        if (userAnswer == correct) {
            score++
            binding.txtFeedback.text = "Correct!"
        } else {
            binding.txtFeedback.text = "Incorrect."
        }
        Log.d("Quiz", "Question ${currentIndex + 1}: User answered $userAnswer, Correct: $correct")
    }
}
