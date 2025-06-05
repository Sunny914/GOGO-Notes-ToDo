package com.sunny.gogonotesandtodo.DB

import androidx.room.TypeConverter
import java.time.LocalDate

class TypeConverters {
    @TypeConverter
    fun fromLocalDate(date : LocalDate) : String{
        return date.toString()
    }

    @TypeConverter
    fun toLocalDate(date : String) : LocalDate{
        return LocalDate.parse(date)
    }
}