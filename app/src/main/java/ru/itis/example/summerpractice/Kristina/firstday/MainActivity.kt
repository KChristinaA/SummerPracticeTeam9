package ru.itis.example.summerpractice.Kristina.firstday

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analyzeIntList(listOf(67, -14, 22, -8, 15))
    }

    private fun analyzeIntList(input: List<Int>) {
        val minNum = input.min()
        val maxNum = input.max()
        val sumOfNum = input.sum()
        var oddNumCounter = 0
        var evenNumCounter = 0
        input.forEach { num ->
            if (num % 2 != 0) oddNumCounter++ else evenNumCounter++
        }

        println("TEST-TAG Минимальное: $minNum")
        println("TEST-TAG Максимальное: $maxNum")
        println("TEST-TAG Сумма: $sumOfNum")
        println("TEST-TAG Количество чётных: $evenNumCounter")
        println("TEST-TAG Количество нечётных: $oddNumCounter")
    }
}