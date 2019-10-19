package com.example.restapi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.restapi.Fragment.NewPlaying
import com.example.restapi.Fragment.UpComing
import com.example.restapi.POJO.NowPlaying

class TabAdapter (fm : FragmentManager?): FragmentStatePagerAdapter(fm!!){
    override fun getItem(position: Int): Fragment {
        if (position == 0){
            return NewPlaying()
        }else {
            return UpComing()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}