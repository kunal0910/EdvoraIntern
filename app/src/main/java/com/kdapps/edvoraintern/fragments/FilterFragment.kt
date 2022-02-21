package com.kdapps.edvoraintern.fragments

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.kdapps.edvoraintern.MainActivity
import com.kdapps.edvoraintern.R
import com.kdapps.edvoraintern.RideAdapter
import com.kdapps.edvoraintern.database.RoomDatabaseBuilder
import com.kdapps.edvoraintern.entities.RideEntity
import kotlinx.android.synthetic.main.filter_layout.*
import kotlinx.android.synthetic.main.filter_layout.view.*


class FilterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.filter_layout, container, false)
        ArrayAdapter.createFromResource(
            activity as Context,
            R.array.state_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            view.state_spinner.adapter = adapter
            view.state_spinner.prompt = "State"
        }

        ArrayAdapter.createFromResource(
            activity as Context,
            R.array.city_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            view.city_spinner2.adapter = adapter
            view.city_spinner2.prompt = "City"
        }

        view.state_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                val state_name = p0?.getItemAtPosition(pos)
                when(pos){
                    0 ->{
                        ArrayAdapter.createFromResource(
                            activity as Context,
                            R.array.Maharashtra,
                            android.R.layout.simple_spinner_item
                        ).also { adapter ->
                            // Specify the layout to use when the list of choices appears
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            // Apply the adapter to the spinner
                            view.city_spinner2.adapter = adapter
                            view.city_spinner2.prompt = "City"
                        }
                    }

                    1  ->{
                        ArrayAdapter.createFromResource(
                            activity as Context,
                            R.array.Punjab,
                            android.R.layout.simple_spinner_item
                        ).also { adapter ->
                            // Specify the layout to use when the list of choices appears
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            // Apply the adapter to the spinner
                            view.city_spinner2.adapter = adapter
                            view.city_spinner2.prompt = "City"
                        }
                    }

                    2 ->{
                        ArrayAdapter.createFromResource(
                            activity as Context,
                            R.array.MP,
                            android.R.layout.simple_spinner_item
                        ).also { adapter ->
                            // Specify the layout to use when the list of choices appears
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            // Apply the adapter to the spinner
                            view.city_spinner2.adapter = adapter
                            view.city_spinner2.prompt = "City"
                        }
                    }

                    3 ->{
                        ArrayAdapter.createFromResource(
                            activity as Context,
                            R.array.UP,
                            android.R.layout.simple_spinner_item
                        ).also { adapter ->
                            // Specify the layout to use when the list of choices appears
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            // Apply the adapter to the spinner
                            view.city_spinner2.adapter = adapter
                            view.city_spinner2.prompt = "City"
                        }
                    }
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



        view.btn_show_results.setOnClickListener(){
            requireActivity().onBackPressed()

        }

        return view
    }

}