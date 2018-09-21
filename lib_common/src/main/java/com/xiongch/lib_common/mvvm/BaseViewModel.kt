package com.xiongch.lib_common.mvvm

import android.arch.lifecycle.*
import com.xiongch.lib_common.extensions.update
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel(), LifecycleObserver {

    protected val mDisposable = CompositeDisposable()

    val mLoadingVisible = MutableLiveData<Boolean>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected open fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected open fun onResume() {

    }

    override fun onCleared() {
        mDisposable.clear()
        super.onCleared()
    }

    fun showLoading() {
        mLoadingVisible.update(true)
    }

    fun dismissLoading() {
        mLoadingVisible.update(false)
    }
}