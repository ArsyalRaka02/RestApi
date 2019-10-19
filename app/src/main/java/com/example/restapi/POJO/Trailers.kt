package com.example.restapi.POJO

import com.google.gson.annotations.SerializedName

class Trailers {

    @SerializedName("result")
    var tailers_result: List<Data>? = null


    class Data {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("key")
        var key: String? = null

        @SerializedName("name")
        var name: String? = null

        @SerializedName("type")
        var type: String? = null

        @SerializedName("site")
        var site: String? = null

    }

}