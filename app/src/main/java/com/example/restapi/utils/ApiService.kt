package com.example.restapi.utils

import com.example.restapi.POJO.DetailMovie
import com.example.restapi.POJO.NowPlaying
import com.example.restapi.POJO.Trailers
import com.example.restapi.POJO.Upcoming
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("now_playing")
    fun requestNowPlaying(
        @Query("api_key") apiKey: String
        ): Call<NowPlaying>

    @GET("upcoming")
    fun requestUpcoming(
        @Query("api_key") apiKey: String
    ): Call<Upcoming>

    @GET("{detail_id}")
    fun requestDetail(
        @Path("detail_id") movieID: Int,
        @Query("api_key") apiKey: String
    ): Call<DetailMovie>

    @GET("{trailer_id}/videos")
    fun requestTrailer(
        @Path("trailer_id") trailerID: Int,
        @Query("api_key") apiKey: String
    ): Call<Trailers>


}