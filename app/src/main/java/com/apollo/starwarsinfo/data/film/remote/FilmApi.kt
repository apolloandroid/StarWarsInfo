package com.apollo.starwarsinfo.data.film.remote

import retrofit2.http.GET

interface FilmApi {

    @GET("/films")
    suspend fun getFilms(): GetFilmsResponseDto
}