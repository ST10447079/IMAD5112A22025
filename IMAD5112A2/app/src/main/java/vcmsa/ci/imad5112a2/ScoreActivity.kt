package com.example.flashcardquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcardquiz.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("score", 0)
        val feedback = if (score >= 3) "Great job!" else "Keep practising!"
        binding.txtScore.text = "Your Score: $score/5\n$feedback"

        binding.btnReview.setOnClickListener {
            val reviewIntent = Intent(this, ReviewActivity::class.java)
            reviewIntent.putExtras(intent)
            startActivity(reviewIntent)
        }

        binding.btnExit.setOnClickListener {
            finishAffinity()  // Terminates the app
        }
    }
}
