package com.xiongch.lib_common.rxbus


import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

/**
 * Created by xiongchang on 2017/10/28.
 */

object RxBus {

    private val subject = PublishSubject.create<Any>().toSerialized()

    fun post(event: Any) {
        subject.onNext(event)
    }

    fun <T> subscribe(bean: Class<T>, consumer: Consumer<T>): Disposable {
        return toObservable(bean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer)
    }

    private fun <T> toObservable(classType: Class<T>): Observable<T> {
        return subject.ofType(classType)
    }

}
