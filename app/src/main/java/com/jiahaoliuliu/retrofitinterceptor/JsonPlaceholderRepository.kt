package com.jiahaoliuliu.retrofitinterceptor

import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class JsonPlaceholderRepository {
    companion object {
        private const val BASE_URL = "http://jsonplaceholder.typicode.com"
    }

    var jsonPlaceholderApi: JsonPlaceholderApi

    init {
        val okHttpClient = OkHttpClient.Builder().build()
        val retroFit = Retrofit.Builder().client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        jsonPlaceholderApi = retroFit.create(JsonPlaceholderApi::class.java)
    }

    fun getPosts(): Single<List<Post>> {
        return jsonPlaceholderApi.getPosts()
    }
}