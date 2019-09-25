package com.jiahaoliuliu.retrofitinterceptor

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import kotlin.random.Random

class MainPresenter(private val view:MainContract.View): MainContract.Presenter {

    private val jsonPlaceholderRepository = WishRepository()
    private val compositeDisposable = CompositeDisposable()

    override fun makeAWish() {
        val disposable = jsonPlaceholderRepository.getWishesList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({wishesList ->
                view.showWish(wishesList[Random.nextInt(0, wishesList.size)])},
                {throwable -> Timber.e(throwable)})
        compositeDisposable.add(disposable)
    }

    override fun onViewDestroyed() {
        compositeDisposable.clear()
    }
}