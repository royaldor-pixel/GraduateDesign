package com.example.graduatedesign.api

import com.example.graduatedesign.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class RetrofitInstance {

    companion object {

        private val retrofit by lazy {
//      An interceptor is a mechanism to intercept Http call,
//      which can also monitor, rewrite and retry calls
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        }

        val api: NewsAPI by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}