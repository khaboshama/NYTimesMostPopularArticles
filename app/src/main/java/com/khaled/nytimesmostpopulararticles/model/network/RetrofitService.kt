package com.khaled.nytimesmostpopulararticles.model.network

import com.khaled.nytimesmostpopulararticles.constant.Constants
import com.khaled.nytimesmostpopulararticles.model.network.end_points.MostPopularArticleApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val mostPopularServiceApi: MostPopularArticleApi by lazy {
        getRetrofit().create(MostPopularArticleApi::class.java)
    }

    private fun getRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .client(httpClient.build())
            .build()
    }
}