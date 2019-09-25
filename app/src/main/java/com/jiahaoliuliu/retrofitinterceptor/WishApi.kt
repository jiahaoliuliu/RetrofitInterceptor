package com.jiahaoliuliu.retrofitinterceptor

import io.reactivex.Single
import retrofit2.http.GET

interface WishApi {

    @GET("wish")
    fun getWishesList(): Single<List<Wish>>
}