package com.jiahaoliuliu.retrofitinterceptor

import io.reactivex.Single
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("posts")
    fun getPosts(): Single<List<Post>>
}