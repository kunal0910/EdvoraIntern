package com.kdapps.edvoraintern.database

import android.content.Context
import android.os.AsyncTask
import com.kdapps.edvoraintern.entities.RideEntity

class RideDBAsyncTask(val context: Context, val rideEntity: RideEntity, val mode: Int)
    :AsyncTask<Void, Void, Boolean>(){

    val db = RoomDatabaseBuilder(context).getRoomDatabase()
    override fun doInBackground(vararg p0: Void?): Boolean {
        when(mode){
            1 ->{
                db.rideDetailsDao().insertRideDetails(rideEntity)
                db.close()
                return true
            }
            2 ->{
                db.rideDetailsDao().deleteRideDetails(rideEntity)
                db.close()
                return true
            }
        }
        return false
    }
}