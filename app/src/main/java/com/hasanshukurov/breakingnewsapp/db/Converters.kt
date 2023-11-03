package com.hasanshukurov.breakingnewsapp.db

import androidx.room.TypeConverter
import com.hasanshukurov.breakingnewsapp.model.Source
import javax.annotation.meta.TypeQualifier

class Converters {


    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name,name)
    }

}