package com.apollo.starwarsinfo.data.character.remote

import com.apollo.starwarsinfo.domain.model.Character
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    @SerialName("url")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("birth_year")
    val birthDate: String,
    @SerialName("films")
    val filmsIds: List<String>,
    @SerialName("homeworld")
    val planetId: String
) {

    fun mapToDomain(): Character = Character(
        id = this.id,
        name = this.name,
        gender = this.gender,
        birthDate = this.birthDate,
        filmsIds = this.filmsIds.map { id -> id.filter { it.isDigit() } },
        planetId = this.planetId.filter { it.isDigit() }
    )
}