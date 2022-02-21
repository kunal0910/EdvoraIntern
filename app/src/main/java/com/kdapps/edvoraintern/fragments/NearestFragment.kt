package com.kdapps.edvoraintern.fragments

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kdapps.edvoraintern.MainActivity
import com.kdapps.edvoraintern.R
import com.kdapps.edvoraintern.RideAdapter
import com.kdapps.edvoraintern.database.RideDBAsyncTask
import com.kdapps.edvoraintern.database.RoomDatabaseBuilder
import com.kdapps.edvoraintern.entities.RideEntity
import kotlinx.android.synthetic.main.fragment_nearest.view.*
import java.util.concurrent.CopyOnWriteArrayList

class NearestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_nearest, container, false)

        val list = getAllRides(activity as Context).execute().get()
        view.nearest_recycler_view.apply {
            adapter = RideAdapter(activity as Context,list)
            layoutManager = LinearLayoutManager(activity)
        }

        return view
    }


    class getAllRides(val context: Context):AsyncTask<Void, Void, List<RideEntity>>(){
        override fun doInBackground(vararg p0: Void?): List<RideEntity> {
            val db = RoomDatabaseBuilder(context).getRoomDatabase()
            val result = db.rideDetailsDao().getAllRIdeDetails()
            db.close()
            return result
        }

    }

}