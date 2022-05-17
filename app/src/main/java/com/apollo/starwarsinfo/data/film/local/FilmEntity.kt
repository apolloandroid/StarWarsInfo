package com.apollo.starwarsinfo.data.film.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.apollo.starwarsinfo.domain.model.Film

@Entity(tableName = FilmDao.TABLE_NAME)
data class FilmEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "director_name")
    val directorName: String,
    @ColumnInfo(name = "producer_name")
    val producerName: String,
    @ColumnInfo(name = "release_year")
    val releaseYear: String,
    @ColumnInfo(name = "characters_ids")
    val charactersIds: List<String>
) {

    companion object {
        fun mapFromDomain(film: Film): FilmEntity = FilmEntity(
            id = film.id,
            title = film.title,
            directorName = film.directorName,
            producerName = film.producerName,
            releaseYear = film.releaseYear,
            charactersIds = film.charactersIds
        )
    }

    fun mapToDomain(): Film = Film(
        id = this.id,
        title = this.title,
        directorName = this.directorName,
        producerName = this.producerName,
        releaseYear = this.releaseYear,
        charactersIds = this.charactersIds
    )
}