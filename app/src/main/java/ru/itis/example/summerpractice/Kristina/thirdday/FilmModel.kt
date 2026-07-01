package ru.itis.example.summerpractice.Kristina.thirdday

import kotlinx.serialization.Serializable

@Serializable
data class FilmModel(
    val id: String,
    val posterUrl: String,
    val name: String,
    val description: String?,
    val releaseDate: Int
)
