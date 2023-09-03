package com.example.jectpack.repo

import com.example.jectpack.model.LatestMovieResponse
import com.example.jectpack.retrofit.RetrofitClient

class Repository {

    private val retrofit = RetrofitClient.retrofitApi

    suspend fun getLatestMovies(): LatestMovieResponse {
        return retrofit.getLatestMovie("day")
    }

}