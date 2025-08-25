package com.example.iogando

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private var timer: Timer? = null
    private var seconds = 0
    private lateinit var timerText: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerText = findViewById(R.id.timerText)
        imageView = findViewById(R.id.imageView)

        val btnImg1: Button = findViewById(R.id.btnImg1)
        val btnImg2: Button = findViewById(R.id.btnImg2)
        val btnImg3: Button = findViewById(R.id.btnImg3)
        val btnImg4: Button = findViewById(R.id.btnImg4)
        val btnStartStop: Button = findViewById(R.id.btnStartStop)

        btnImg1.setOnClickListener { imageView.setImageResource(R.drawable.fundo1) }
        btnImg2.setOnClickListener { imageView.setImageResource(R.drawable.fundo2) }
        btnImg3.setOnClickListener { imageView.setImageResource(R.drawable.fundo3) }
        btnImg4.setOnClickListener { imageView.setImageResource(R.drawable.fundo4) }

        btnStartStop.setOnClickListener {
            if (timer == null) startTimer() else stopTimer()
        }
    }

    private fun startTimer() {
        timer = timer(period = 1000) {
            seconds++
            runOnUiThread {
                val min = seconds / 60
                val sec = seconds % 60
                timerText.text = String.format("%02d:%02d", min, sec)
            }
        }
    }

    private fun stopTimer() {
        timer?.cancel()
        timer = null
    }
}
