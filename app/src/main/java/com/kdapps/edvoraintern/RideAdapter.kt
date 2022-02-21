package com.kdapps.edvoraintern

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kdapps.edvoraintern.entities.RideEntity
import kotlinx.android.synthetic.main.ride_recycler_item_view.view.*
import java.text.SimpleDateFormat

class RideAdapter(val context: Context, val rideDetailsList: List<RideEntity>):RecyclerView.Adapter<RideAdapter.viewHolder>() {

    class viewHolder(view: View): RecyclerView.ViewHolder(view){
        val tv_ride_id = view.tv_ride_id
        val tv_origin_station = view.tv_origin_station
        val tv_city = view.tv_city
        val tv_state = view.tv_state
        val tv_date = view.tv_date
        val tv_distance = view.tv_distance
        val tv_station_path = view.tv_station_path

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.ride_recycler_item_view, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val rideId = rideDetailsList[position].id
        val origin = rideDetailsList[position].origin_station_code
        val city = rideDetailsList[position].city
        val state = rideDetailsList[position].state
        val station_path = rideDetailsList[position].station_path

        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm")
        val dateString = sdf.format(rideDetailsList[position].date.toInt())

        holder.tv_city.setText(city)
        holder.tv_state.setText(state)
        holder.tv_date.setText(dateString)
        holder.tv_ride_id.setText(rideId)
        holder.tv_origin_station.setText(origin)
        holder.tv_station_path.setText(station_path)

        val station_path_array = station_path.substring(1,27)
        val array = station_path_array.split(",")
        Log.e("array", array.toString())
        val distance = getDistance(array, origin).toString()
        holder.tv_distance.setText(distance)
    }

    override fun getItemCount(): Int {
        return rideDetailsList.size
    }

    fun getDistance(array: List<String>, stationCode: String): Int{
        var smallest: Int = stationCode.toInt()
        var temp:Int
        val code = stationCode.toInt()
        for(i in array){
            Log.e("current", i)
            val num = i.toInt()
            temp = code - num
            temp = Math.abs(temp)
            Log.e("current_dist", temp.toString())
            if(temp < smallest ){
                smallest = temp
            }
        }
        return smallest
    }

    fun applyRideFilter(city: String, state: String){
        if(city != ""){
            rideDetailsList.filter { it.city == city }
        }
        else{
            rideDetailsList.filter { it.state == state }
        }
        notifyDataSetChanged()
    }
}