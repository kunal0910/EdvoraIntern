package com.kdapps.edvoraintern.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kdapps.edvoraintern.entities.RideEntity


@Database(entities = arrayOf(RideEntity::class), version = 1)
abstract class RoomDatabase: RoomDatabase() {
    abstract fun rideDetailsDao(): RideDetailsDao
}