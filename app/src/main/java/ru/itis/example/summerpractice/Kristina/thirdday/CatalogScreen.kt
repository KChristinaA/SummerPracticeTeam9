package ru.itis.example.summerpractice.Kristina.thirdday

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.itis.example.summerpractice.R

@Composable
fun CatalogScreen() {
    val catalog = Data.filmList
    var screenList by remember { mutableStateOf(catalog) }
    //val scrollState = rememberScrollState()
    var userInput by remember { mutableStateOf("") }
    var errorType by remember { mutableStateOf<CatalogScreenError?>(null) }
    Column(
        modifier = Modifier
            //.verticalScroll(scrollState)
            .padding(vertical = 32.dp)
    ) {
        val isNotFoundError = errorType == CatalogScreenError.NOT_FOUND
        val isNotAYearError = errorType == CatalogScreenError.NOT_A_YEAR
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = userInput,
                onValueChange = { newValue ->
                    userInput = newValue
                    errorType = null
                },
                label = {Text(text = stringResource(R.string.enter_the_year))},
                isError = isNotAYearError || isNotFoundError,
                supportingText = {
                    when {
                        isNotFoundError -> Text(text = stringResource(R.string.not_found_error))
                        isNotAYearError -> Text(text = stringResource(R.string.not_a_year_error))
                    }
                },
                modifier = Modifier.width(200.dp),
                maxLines = 1
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                val input = userInput.toIntOrNull()
                screenList = catalog.filter { film -> film.releaseDate == input }
                if (screenList.isEmpty() && input != null) {
                    errorType = CatalogScreenError.NOT_FOUND
                } else if (screenList.isEmpty()) errorType = CatalogScreenError.NOT_A_YEAR
                if (userInput.isEmpty()) {
                    screenList = catalog
                    errorType = null
                }
            },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            ) {
                Text (text = stringResource(R.string.sort))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.padding(vertical = 16.dp)) {
            items(count = screenList.size,
                key = {index -> screenList[index].id}
                ) { index -> val film = screenList[index]
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    AsyncImage(
                        model = film.posterUrl,
                        contentDescription = null,
                        modifier = Modifier.size(128.dp)
                            .align(Alignment.CenterVertically)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = film.name.plus(" (${film.releaseDate})"),
                            fontSize = TextUnit(24f, TextUnitType.Sp),
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        film.description?.let {
                            Text(text = film.description)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }
}

private enum class CatalogScreenError {
    NOT_FOUND,
    NOT_A_YEAR
}