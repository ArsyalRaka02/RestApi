package com.example.restapi.POJO
import com.google.gson.annotations.SerializedName



class DetailMovie {

    @SerializedName("backdrop_path")
    val backdrop_path: String? = null

    @SerializedName("budget")
    val budget: String? = null

    @SerializedName("genres")
    val genres: List<Genre>? = null

    class Genre{

        @SerializedName("id")
        val genreId: String? = null

        @SerializedName("name")
        val genre: String? = null

    }

    @SerializedName("homepage")
    val homepage_url: String? = null

    @SerializedName("vote_count")
    val vote_count: Int? = null

    @SerializedName("vote_avarage")
    val vote_avarage: String? = null

    @SerializedName("original_title")
    val original_title: String? = null

    @SerializedName("overview")
    val overview: String? = null

    @SerializedName("production_companies")
    val production_companies: List<Company>? = null

    class Company {

        @SerializedName("name")
        val company_name: String? = null

        @SerializedName("id")
        val company_id: String? = null

    }

    @SerializedName("release_date")
    val release_date: String? = null

    @SerializedName("runtime")
    val runtime: String? = null

}