package com.sunny.gogonotesandtodo.DB

import androidx.room.TypeConverters
import java.util.Date

class Converters {

    @TypeConverters
    fun fromDate(date : Date) : Long{
        return date.time
    }

    @TypeConverters
    fun toDate(time : Long) : Date{
        return Date(time)
    }
}