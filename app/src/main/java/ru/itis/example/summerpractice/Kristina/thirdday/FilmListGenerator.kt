package ru.itis.example.summerpractice.Kristina.thirdday

fun generateListOfFilms(number: Int): List<FilmModel> {
    val listOfFilms = FilmsCatalog.getFilmList().shuffled()
    return listOfFilms.take(number)
}