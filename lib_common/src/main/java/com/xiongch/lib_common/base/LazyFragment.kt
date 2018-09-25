package com.xiongch.lib_common.base

import androidx.databinding.ViewDataBinding
import android.os.Bundle

abstract class LazyFragment<T : ViewDataBinding> : BaseFragment<T>() {
    private var isViewInitiated = false //控件是否初始化完成
    private var isVisibleToUser = false //页面是否可见
    private var isDataInitiated = false //数据是否加载

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        prepareFetchData(isForceUpdate())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isViewInitiated = true
        prepareFetchData(isForceUpdate())
    }

    protected open fun lazyFetchData() {}

    private fun prepareFetchData(forceUpdate: Boolean) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            lazyFetchData()
            isDataInitiated = true
        }
    }

    //是否开启懒加载
    protected open fun isForceUpdate() = false
}