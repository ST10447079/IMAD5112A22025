package com.example.flashcardquiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcardquiz.databinding.ActivityReviewBinding

class ReviewActivity<ActivityReviewBinding> : AppCompatActivity() {
    private var binding: ActivityReviewBinding = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (ActivityReviewBinding.inflate(layoutInflater)).also {
            val it = null
            binding = it
        }
        setContentView(binding.root)

        val questions = intent.getStringArrayExtra("questions")!!
        val answers = intent.getBooleanArrayExtra("answers")!!
        val userAnswers = intent.getBooleanArrayExtra("userAnswers")!!

        val result = StringBuilder()
        for (i in questions.indices) {
            result.append("${i + 1}. ${questions[i]}\n")
            result.append("Correct Answer: ${answers[i]}\n")
            result.append("Your Answer: ${userAnswers[i]}\n\n")
        }

        binding.txtReview.text = result.toString()
    }
}
