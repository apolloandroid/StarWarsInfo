package com.apollo.starwarsinfo.data.film.remote

import com.apollo.starwarsinfo.domain.model.Film
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class FilmDto(
    @SerialName("episode_id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("director")
    val directorName: String,
    @SerialName("producer")
    val producerName: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("characters")
    val charactersIds: List<String>
) {

    fun mapToDomain(): Film = Film(
        id = this.id.toString(),
        title = this.title,
        directorName = this.directorName,
        producerName = this.producerName,
        releaseYear = LocalDate.parse(this.releaseDate).year.toString(),
        charactersIds = this.charactersIds.map { id -> id.filter { it.isDigit() } }
    )
}