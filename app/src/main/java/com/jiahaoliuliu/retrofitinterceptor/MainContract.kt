package com.jiahaoliuliu.retrofitinterceptor

interface MainContract {

    interface View {
        fun showWish(wishesList: List<Wish>)
    }

    interface Presenter {
        fun makeAWish()

        fun onViewDestroyed()
    }
}