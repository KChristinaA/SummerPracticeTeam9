package ru.itis.example.summerpractice.Kristina.secondday.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivityRandomizer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val randomNum = (1..100).random()
        setContent {
            Guessing(randomNum = randomNum)
        }
    }
}