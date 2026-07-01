package ru.itis.example.summerpractice.Kristina.secondday.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Guessing(randomNum: Int) {
    var userInput by remember { mutableStateOf("") }
    var actualNumber by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(vertical = 200.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextOnScreen(exactNum = randomNum, numInput = actualNumber)

        Spacer(modifier = Modifier.height(15.dp))

        Row (horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = userInput,
                onValueChange = { newValue ->
                    userInput = newValue
                    actualNumber = ""
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                label = { Text(text = "Введите число")}
            )

            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = {
                val input = userInput.toIntOrNull()
                if (input != null && input in (1..100)) {
                    actualNumber = userInput
                    userInput = ""
                }
            }
            ) {
                Text (text = "Отправить")
            }
        }
    }
}