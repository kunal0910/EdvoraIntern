package com.kdapps.edvoraintern.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kdapps.edvoraintern.entities.RideEntity


@Dao
interface RideDetailsDao {

    @Insert
    fun insertRideDetails(rideEntity: RideEntity)

    @Delete
    fun deleteRideDetails(rideEntity: RideEntity)

    @Query("SELECT * FROM tblRideDetails")
    fun getAllRIdeDetails(): List<RideEntity>
}