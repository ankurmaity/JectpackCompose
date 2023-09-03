package com.example.jectpack.model

import com.google.gson.annotations.SerializedName


data class LatestMovieResponse(

    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<Movie> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null

)