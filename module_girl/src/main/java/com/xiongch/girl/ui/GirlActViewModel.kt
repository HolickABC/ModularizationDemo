package com.xiongch.girl.ui

import androidx.lifecycle.MutableLiveData
import com.xiongch.lib_common.api.repository.TestRepository
import com.xiongch.lib_common.extensions.addTo
import com.xiongch.lib_common.http.ObserverWrapper
import com.xiongch.lib_common.mvvm.BaseViewModel
import javax.inject.Inject

class GirlActViewModel @Inject constructor(private val testRepository: TestRepository) : BaseViewModel() {

    val test = MutableLiveData<Boolean>()

    fun test(block: (Boolean) -> Unit) {
        testRepository.test()
                .subscribeWith(object : ObserverWrapper<Boolean>(this) {
                    override fun next(t: Boolean) {
                        super.next(t)
                        block(t)
                    }
                }).addTo(mDisposable)
    }
}