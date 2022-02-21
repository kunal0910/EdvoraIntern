package com.kdapps.edvoraintern.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tblRideDetails")
data class RideEntity (
    @PrimaryKey val id: String,
    @ColumnInfo(name = "origin_station_code") val origin_station_code: String,
    @ColumnInfo(name = "station_path") val station_path: String,
    @ColumnInfo(name = "destination_station_code") val destination_station_code:String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "map_url") val map_url: String,
    @ColumnInfo(name = "state") val state: String,
    @ColumnInfo(name = "city") val city: String
    )