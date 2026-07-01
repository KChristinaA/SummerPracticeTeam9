package ru.itis.example.summerpractice.Kristina.secondday.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@Composable
fun TextOnScreen(exactNum: Int, numInput: String) {
    var answer = "Введите число от 1 до 100"
    val num = numInput.toIntOrNull()
    num?.let {
        if (num > exactNum) answer = "Введённое число больше загаданного"
        else if (num == exactNum) {
            PictureOnScreen()
            return
        }
        else answer = "Введённое число меньше загаданного"
    }
    Text (text = answer,
        fontSize = TextUnit(24f, TextUnitType.Sp),
        fontStyle = FontStyle.Italic)
}