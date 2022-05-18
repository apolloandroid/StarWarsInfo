package com.apollo.starwarsinfo.data.character.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.apollo.starwarsinfo.domain.model.Character

@Entity(tableName = CharacterDao.TABLE_NAME)
data class CharacterEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "birth_date")
    val birthDate: String,
    @ColumnInfo(name = "films_ids")
    val filmsIds: List<String>,
    @ColumnInfo(name = "planet_id")
    val planetId: String
) {

    companion object {
        fun mapFromDomain(character: Character): CharacterEntity = CharacterEntity(
            id = character.id,
            name = character.name,
            gender = character.gender,
            birthDate = character.birthDate,
            filmsIds = character.filmsIds,
            planetId = character.planetId
        )
    }

    fun mapToDomain(): Character = Character(
        id = this.id,
        name = this.name,
        gender = this.gender,
        birthDate = this.birthDate,
        filmsIds = this.filmsIds,
        planetId = this.planetId
    )
}