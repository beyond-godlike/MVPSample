package com.unava.dia.mvpsample.base

import io.reactivex.disposables.Disposable
import io.reactivex.disposables.CompositeDisposable


abstract class BasePresenter<V> protected constructor(protected val view: V) {

    private val disposables = CompositeDisposable()

    enum class RequestState {
        IDLE,
        LOADING,
        COMPLETE,
        ERROR
    }

    fun start() {}

    fun stop() {
        disposables.clear()
    }

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}