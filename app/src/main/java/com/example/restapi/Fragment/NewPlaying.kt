package com.example.restapi.Fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.restapi.POJO.NowPlaying

import com.example.restapi.R
import com.example.restapi.adapter.NowPlayingAdapter
import com.example.restapi.utils.EndPoint
import com.example.restapi.utils.InitRetrofit
import kotlinx.android.synthetic.main.fragment_new_playing.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewPlaying : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_new_playing, container, false)
        var swipe = view.findViewById<View>(R.id.refresh_now_playing) as SwipeRefreshLayout
        swipe.setOnRefreshListener {
            swipe.isRefreshing = false
            getNowPlaying()
        }

        getNowPlaying()

        return  view
    }

    private fun getNowPlaying(){
        var api = InitRetrofit().getInitInstance()
        var call = api.requestNowPlaying(EndPoint.API_KEY)
        call.enqueue(object : Callback<NowPlaying>{
            override fun onFailure(call: Call<NowPlaying>?, t: Throwable) {
                t.printStackTrace()
                Log.d("Movie status", "failure")
            }

            override fun onResponse(call: Call<NowPlaying>?, response: Response<NowPlaying>?) {
                if (response != null){
                    if (response.isSuccessful){
                        Log.d("Movie status", "failure")
                        var data = response.body()?.data
                        val adapter = NowPlayingAdapter(activity, data)
                        rv_now_playing.adapter = adapter
                        rv_now_playing.layoutManager = GridLayoutManager(activity, 2)
                    } else {
                        Log.d("Movie status", "failure")
                    }
                }
            }
        })
    }
}
