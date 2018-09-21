package com.xiongch.lib_common.http

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by xiongchang on 17/6/27.
 */

class SchedulerTransformer<T> : ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): Observable<T> {
        return upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    companion object {

        fun <T> create(): SchedulerTransformer<T> {
            return SchedulerTransformer()
        }
    }
}
