package com.example.restapi.POJO

import com.google.gson.annotations.SerializedName

class Upcoming {

    @SerializedName("results")
    var data: List<UpcomingData>? = null

    inner class UpcomingData{
        @SerializedName("vote_count")
        var vote_count : Int? = null

        @SerializedName("id")
        var idMovie : Int? = null

        @SerializedName("vote_avarage")
        var vote_avarage: Double? = null

        @SerializedName("title")
        var movieTitle : String? = null

        @SerializedName("popularity")
        var popularity : Double? = null

        @SerializedName("poster_path")
        var poster_path : String? = null

        @SerializedName("backdrop_path")
        var backdrop_path : String? = null

        @SerializedName("overview")
        var overview : String? = null

        @SerializedName("release_date")
        var release_date : String? = null

    }
}