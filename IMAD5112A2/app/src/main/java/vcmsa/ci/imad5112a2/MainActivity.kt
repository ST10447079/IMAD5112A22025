package com.example.flashcardquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    class ActivityMainBinding {
        val btnStart: Any
            get() {
                TODO()
            }
        val root: Any
            get() {
                TODO("Not yet implemented")
            }

        companion object {
            fun <LayoutInflater> inflate(inflater: LayoutInflater): MainActivity.ActivityMainBinding {

                return TODO("Provide the return value")
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }

    class QuizActivity {

    }

    private fun setContentView(root: Any) {

    }
}

private fun Any.setOnClickListener(function: () -> Unit) {
    TODO("Not yet implemented")
}
