package ru.itis.example.summerpractice.Kristina.firstday

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analyzeIntList(listOf(67, -14, 22, -8, 15))
    }

    private fun analyzeIntList(input: List<Int>) {
        var minNum: Int = input.get(0)
        var maxNum: Int = input.get(0)
        var sumOfNum: Int = 0
        var oddNumCounter: Int = 0
        var evenNumCounter: Int = 0
        for (num in input) {
            if (num < minNum) minNum = num
            if (num > maxNum) maxNum = num
            if (num % 2 != 0) oddNumCounter++ else evenNumCounter++
            sumOfNum += num
        }
        println("TEST-TAG Минимальное: $minNum")
        println("TEST-TAG Максимальное: $maxNum")
        println("TEST-TAG Сумма: $sumOfNum")
        println("TEST-TAG Количество чётных: $evenNumCounter")
        println("TEST-TAG Количество нечётных: $oddNumCounter")
    }
}