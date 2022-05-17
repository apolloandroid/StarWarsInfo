package com.apollo.starwarsinfo.data

import androidx.room.TypeConverter

object StringConverter {

    private const val separator = ","

    @TypeConverter
    @JvmStatic
    fun convertListToString(strings: List<String>): String = strings.joinToString(separator)

    @TypeConverter
    @JvmStatic
    fun convertStringToList(string: String): List<String> = string.split(separator)
}