package ru.itis.example.summerpractice.Kristina.secondday.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import coil3.compose.AsyncImage

@Composable
fun PictureOnScreen() {
    Box (modifier = Modifier
        .size(200.dp),
        contentAlignment = Alignment.Center) {
        AsyncImage(
            model = "https://i.pinimg.com/474x/53/26/46/532646dc4fb356dd57254de98cfaca11.jpg",
            contentDescription = null
        )
    }
}