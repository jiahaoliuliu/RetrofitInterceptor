package com.jiahaoliuliu.retrofitinterceptor

import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WishRepository {
    companion object {
        private const val BASE_URL = "https://my-json-server.typicode.com/jiahaoliuliu/RetrofitInterceptor/"
    }

    var wishApi: WishApi

    init {
        val okHttpClient = OkHttpClient.Builder().build()
        val retroFit = Retrofit.Builder().client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        wishApi = retroFit.create(WishApi::class.java)
    }

    fun getWishesList(): Single<List<Wish>> {
        return wishApi.getWishesList()
    }
}