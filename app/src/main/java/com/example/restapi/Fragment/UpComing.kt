package com.example.restapi.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.restapi.POJO.NowPlaying
import com.example.restapi.POJO.Upcoming

import com.example.restapi.R
import com.example.restapi.adapter.NowPlayingAdapter
import com.example.restapi.adapter.UpcomingAdapter
import com.example.restapi.utils.EndPoint
import com.example.restapi.utils.InitRetrofit
import kotlinx.android.synthetic.main.fragment_new_playing.*
import kotlinx.android.synthetic.main.fragment_up_coming.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpComing : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_up_coming, container, false)
        var swipe = view.findViewById<View>(R.id.refresh_upcoming) as SwipeRefreshLayout
        swipe.setOnRefreshListener {
            swipe.isRefreshing = false
            getUpcoming()
        }

        getUpcoming()

        return  view
    }

    private fun getUpcoming(){
        var api = InitRetrofit().getInitInstance()
        var call = api.requestUpcoming(EndPoint.API_KEY)
        call.enqueue(object : Callback<Upcoming> {
            override fun onFailure(call: Call<Upcoming>?, t: Throwable) {

            }

            override fun onResponse(call: Call<Upcoming>?, response: Response<Upcoming>?) {
                if (response != null){
                    if (response.isSuccessful){
                        var data = response.body()?.data
                        val adapter = UpcomingAdapter(activity, data)
                        rv_upcoming.adapter = adapter
                        rv_upcoming.layoutManager = GridLayoutManager(activity, 2)
                    }
                }
            }
        })
    }

}
