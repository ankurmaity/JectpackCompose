package com.example.jectpack.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private val httpClient = OkHttpClient.Builder()
    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    private val interceptor = Interceptor { chain ->
        val newRequest = chain.request().newBuilder()
//            .header("Authorization", "Bearer $TOKEN")
            .build()
        chain.proceed(newRequest)
    }


    private val retrofitBuilder by lazy {
        Retrofit.Builder()
            .baseUrl(RetrofitApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    private val retrofit by lazy {  retrofitBuilder.build()}

    val retrofitApi: RetrofitApi by lazy {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging)
            httpClient.addInterceptor(interceptor)
            retrofitBuilder.client(httpClient.build())
        }
         retrofit.create(RetrofitApi::class.java)
    }
}
