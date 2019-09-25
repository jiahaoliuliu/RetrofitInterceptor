package com.jiahaoliuliu.retrofitinterceptor

interface MainContract {

    interface View {
        fun showWish(postsList: List<Post>)
    }

    interface Presenter {
        fun makeAWish()

        fun onViewDestroyed()
    }
}