package com.jiahaoliuliu.retrofitinterceptor

interface MainContract {

    interface View {
        fun showWish(wish:Wish)
    }

    interface Presenter {
        fun makeAWish()

        fun onViewDestroyed()
    }
}