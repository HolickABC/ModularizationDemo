package com.xiongch.lib_common.base

import android.databinding.ViewDataBinding
import android.util.Log
import com.xiongch.lib_common.extensions.observe
import com.xiongch.lib_common.mvvm.BaseViewModel

abstract class BaseVMActivity<T : ViewDataBinding, VM : BaseViewModel> : BaseActivity<T>() {

    protected lateinit var mViewModel: VM

    override fun onInitPattern() {
        super.onInitPattern()
        mViewModel = getViewModel()
        lifecycle.addObserver(mViewModel)
        registerLiveData()
    }

    protected abstract fun getViewModel(): VM

    private fun registerLiveData() {
        observe(mViewModel.mLoadingVisible) {
            if (it == true) showLoading() else dismissLoading()
        }
    }

    override fun onDestroy() {
        lifecycle.removeObserver(mViewModel)
        super.onDestroy()
    }
}