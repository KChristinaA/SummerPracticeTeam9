package ru.itis.example.summerpractice.Kristina.thirdday

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.itis.example.summerpractice.R

@Composable
fun EnterNumberScreen(navController: NavController) {
    var userInput by remember { mutableStateOf("") }
    var actualNumber by remember { mutableStateOf("") }
    var errorType by remember { mutableStateOf<EnterNumberScreenError?>(null) }
    val welcomeText = stringResource(R.string.welcome_text)
    val catalogIsReadyText = stringResource(R.string.catalog_is_ready_text)
    var infoText by remember { mutableStateOf(welcomeText) }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)) {
        val isOutOfRangeError = errorType == EnterNumberScreenError.OUT_OF_RANGE_ERROR
        val isNotNumberError = errorType == EnterNumberScreenError.NOT_NUMBER_ERROR
        Text(text = infoText, fontSize = TextUnit(22f, TextUnitType.Sp))

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userInput,
            onValueChange = { newValue ->
                userInput = newValue
                errorType = null
                actualNumber = ""
                infoText = welcomeText
            },
            label = { Text(text = stringResource(R.string.button_label_text))},
            isError = isNotNumberError || isOutOfRangeError,
            supportingText = {
                when {
                    isNotNumberError -> Text(text = stringResource(R.string.not_number_error))
                    isOutOfRangeError -> Text(text = stringResource(R.string.out_of_range_error))
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                val input = userInput.toIntOrNull()
                if (input == null) {
                    errorType = EnterNumberScreenError.NOT_NUMBER_ERROR
                } else if (input !in (1..10)) {
                    errorType = EnterNumberScreenError.OUT_OF_RANGE_ERROR
                } else {
                    actualNumber = userInput
                    errorType = null
                    Data.filmList = generateListOfFilms(actualNumber.toInt())
                    Data.catalogIsReady = true
                    infoText = catalogIsReadyText
                }
            }
            ) {
                Text (text = stringResource(R.string.first_button_generate))
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                if (Data.catalogIsReady && infoText != welcomeText) {
                    navController.navigate(CatalogScreen)
                }
            }
            ) {
                Text (text = stringResource(R.string.second_button_get_result))
            }
        }
    }
}

private enum class EnterNumberScreenError {
    OUT_OF_RANGE_ERROR,
    NOT_NUMBER_ERROR
}