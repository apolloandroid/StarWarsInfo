package com.apollo.starwarsinfo.domain.model

data class Film(
    val id: String,
    val title: String,
    val directorName: String,
    val producerName: String,
    val releaseYear: String,
    val charactersIds: List<String>
)
