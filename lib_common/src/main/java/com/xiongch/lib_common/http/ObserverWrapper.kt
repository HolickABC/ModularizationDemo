package com.xiongch.lib_common.http

import com.xiongch.lib_common.mvvm.BaseViewModel
import io.reactivex.observers.DisposableObserver

abstract class ObserverWrapper<T> : DisposableObserver<T> {

    private var mViewModel: BaseViewModel? = null

    constructor() : super() {}

    constructor(viewModel: BaseViewModel) : super() {
        mViewModel = viewModel
    }

    override fun onStart() {
        super.onStart()
        showLoading()
        start()
    }

    override fun onNext(t: T) {
        dismissLoading()
        next(t)
    }

    override fun onError(e: Throwable) {
        if (e is APIException) {

        } else {

        }
        dismissLoading()
        error(e)
    }

    override fun onComplete() {
        complete()
    }

    private fun showLoading() {
        mViewModel?.showLoading()
    }

    private fun dismissLoading() {
        mViewModel?.dismissLoading()
    }

    open fun start() {}
    open fun next(t: T) {}
    open fun error(e: Throwable) {}
    open fun complete() {}
}