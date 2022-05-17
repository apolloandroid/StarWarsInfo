package com.apollo.starwarsinfo.domain.model

data class Character(
    val id: String,
    val name: String,
    val gender: String,
    val birthDate: String,
    val filmsIds: String,
    val planetId: String
)
