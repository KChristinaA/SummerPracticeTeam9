package ru.itis.example.summerpractice.firstday

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val password1 = "someTestPassword"
        val password2 = "Лучший_Password123"
        checkPasswordStrength(password1)
        checkPasswordStrength(password2)
    }

    fun checkPasswordStrength(password: String) {
        var strengthCount: Int = 0
        if (password.length >= 8) strengthCount++
        var digitInPassword: Int = 0
        var highLetterInPassword: Int = 0
        var smallLetterInPassword: Int = 0
        var specialSymbolInPassword: Int = 0
        for (symbol in password) {
            if (symbol in '0'..'9') digitInPassword = 1
            if ((symbol in 'A'..'Z') || (symbol in 'А'..'Я') || symbol == 'Ё') highLetterInPassword = 1
            if ((symbol in 'a'..'z') || (symbol in 'а'..'я') || symbol == 'ё') smallLetterInPassword = 1
            if (symbol in "!@\"#№$;%^:&?*()-_+=~`\\|/,.<>{}[]'") specialSymbolInPassword = 1
        }
        strengthCount += digitInPassword + highLetterInPassword + smallLetterInPassword + specialSymbolInPassword
        if (strengthCount == 5) println("TEST-TAG Надёжный пароль")
        else if (strengthCount == 4) println("TEST-TAG Хороший пароль")
        else if (strengthCount >= 2) println("TEST-TAG Средний пароль")
        else println("TEST-TAG Ненадёжный пароль. Меняй")
    }
}