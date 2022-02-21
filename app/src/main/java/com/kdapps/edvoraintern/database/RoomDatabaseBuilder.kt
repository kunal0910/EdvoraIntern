package com.kdapps.edvoraintern.database

import android.content.Context
import androidx.room.Room

class RoomDatabaseBuilder(val context: Context) {
    fun getRoomDatabase(): RoomDatabase{
        val db =Room.databaseBuilder(context, RoomDatabase::class.java, "Edvor_DB").build()
        return  db
    }
}