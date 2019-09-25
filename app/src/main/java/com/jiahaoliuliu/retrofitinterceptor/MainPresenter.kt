package com.jiahaoliuliu.retrofitinterceptor

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainPresenter(private val view:MainContract.View): MainContract.Presenter {

    private val jsonPlaceholderRepository = JsonPlaceholderRepository()
    private val compositeDisposable = CompositeDisposable()

    override fun makeAWish() {
        val disposable = jsonPlaceholderRepository.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::showWish) {throwable -> Timber.e(throwable)}
        compositeDisposable.add(disposable)
    }

    override fun onViewDestroyed() {
        compositeDisposable.clear()
    }
}