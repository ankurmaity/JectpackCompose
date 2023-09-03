package com.example.jectpack.retrofit

import com.example.jectpack.model.LatestMovieResponse
import retrofit2.http.*

interface RetrofitApi {
    @GET(BASE_URL + "trending/movie/{time}?$ACCESS_TOKEN_KEY")
    suspend fun getLatestMovie(@Path("time") time: String): LatestMovieResponse

    companion object {
        const val BASE_URL: String = "https://api.themoviedb.org/3/"
        const val BASE_URL_IMAGE_200 = "https://image.tmdb.org/t/p/w200"
        const val BASE_URL_IMAGE_400 = "https://image.tmdb.org/t/p/w400"

        const val ACCESS_TOKEN_KEY: String ="api_key=45565588cba9e9e81693d6f1432153d2"
        const val ACCESS_TOKEN_AUTH: String =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0NTU2NTU4OGNiYTllOWU4MTY5M2Q2ZjE0MzIxNTNkMiIsInN1YiI6IjVmYTQxZTkwOWFjNTM1MDAzZmIxMGYzNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gDliiygvI109cVcYnq4tKbvH2xFTnS6nRyA-qTMKgUU"
    }
}