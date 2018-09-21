package com.xiongch.lib_common.api.repository

import com.xiongch.lib_common.api.TestApi
import com.xiongch.lib_common.http.ObserverWrapper
import com.xiongch.lib_common.http.RetryWhenNetworkException
import com.xiongch.lib_common.http.SchedulerTransformer
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepository @Inject constructor(retrofit: Retrofit) {

    private lateinit var api: TestApi

    init {
        api = retrofit.create(TestApi::class.java)
    }

    fun test(): Observable<Boolean> {
        return Observable.create<Boolean> {
            it.onNext(true)
            it.onComplete()
        }.compose(SchedulerTransformer.create())
                .retryWhen(RetryWhenNetworkException())
    }
}