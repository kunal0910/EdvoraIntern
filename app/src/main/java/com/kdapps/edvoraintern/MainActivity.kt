package com.kdapps.edvoraintern

import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.kdapps.edvoraintern.database.RideDBAsyncTask
import com.kdapps.edvoraintern.database.RoomDatabaseBuilder
import com.kdapps.edvoraintern.entities.FilterEntity
import com.kdapps.edvoraintern.entities.RideEntity
import com.kdapps.edvoraintern.fragments.FilterFragment
import com.kdapps.edvoraintern.fragments.NearestFragment
import com.kdapps.edvoraintern.fragments.PastFragment
import com.kdapps.edvoraintern.fragments.UpcomingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("edvora_details", MODE_PRIVATE)
        val checkData = sharedPreferences.getBoolean("dataFetched", false)
        if(!checkData){
            main_progress_bar.visibility = View.VISIBLE
            fetchAllDetails()
        }
        setupViewPager(main_view_pager)
        main_tab_layout.setupWithViewPager(main_view_pager)



        btn_filter.setOnClickListener(){
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame_layout, FilterFragment())
                .addToBackStack("Filters")
                .commit()
            this.onPause()
            onResume()

        }
    }

    override fun onResume() {
        super.onResume()
    }



    fun setupViewPager(viewPager: ViewPager){

        var adapter:viewPagerAdapter = viewPagerAdapter(supportFragmentManager)
        adapter.addFragment(NearestFragment(),"Nearest")
        adapter.addFragment(UpcomingFragment(),"Upcoming")
        adapter.addFragment(PastFragment(),"Past")
        viewPager.adapter = adapter
    }

    class viewPagerAdapter: FragmentPagerAdapter{


        private final var fragmentList1: ArrayList<Fragment> = ArrayList()
        private final var fragmentTitleList1: ArrayList<String> = ArrayList()

        public constructor(supportFragmentManager: FragmentManager)
                : super(supportFragmentManager)

        override fun getCount(): Int {
            return fragmentList1.size
        }

        override fun getItem(position: Int): Fragment {
            
            return fragmentList1.get(position)
        }

        @Nullable
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList1.get(position)
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }

    }

    private fun fetchAllDetails(){
        val rideDetailsArray = ArrayList<RideEntity>()
        val rideEntity1 = RideEntity("004","23","[23,42,45,48,56,60,77,81,93]"
        ,"93","1644924365","url","Maharashtra","Panvel")

        val rideEntity2 = RideEntity("005","20","[20,39,40,42,54,63,72,88,98]"
            ,"98","1644924365","url","Maharashtra","Panvel")

        val rideEntity3 = RideEntity("006","13","[13,25,41,48,59,64,75,81,91]"
            ,"91","1644924365","url","Maharashtra","Panvel")
        rideDetailsArray.add(rideEntity1)
        rideDetailsArray.add(rideEntity2)
        rideDetailsArray.add(rideEntity3)
        val iterator = rideDetailsArray.listIterator()
        for(item in iterator){
            Log.e("rideDetails", item.toString())
            val result = RideDBAsyncTask(this, item, 1).execute().get()
        }
        sharedPreferences.edit().putBoolean("dataFetched",true).apply()
        main_progress_bar.visibility = View.INVISIBLE
    }


}