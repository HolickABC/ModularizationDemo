package com.xiongch.lib_common.http

import com.xiongch.lib_common.mvvm.BaseViewModel
import io.reactivex.observers.DisposableObserver

open class ObserverWrapper<T> : DisposableObserver<T> {

    private var mViewModel: BaseViewModel? = null

    constructor() : super() {}

    constructor(viewModel: BaseViewModel) : super() {
        mViewModel = viewModel
    }

    override fun onStart() {
        super.onStart()
        showLoading()
    }

    override fun onNext(t: T) {
        dismissLoading()
    }

    override fun onError(e: Throwable) {
        if (e is APIException) {

        } else {

        }
        dismissLoading()
    }

    override fun onComplete() {

    }

    private fun showLoading() {
        mViewModel?.showLoading()
    }

    private fun dismissLoading() {
        mViewModel?.dismissLoading()
    }

}