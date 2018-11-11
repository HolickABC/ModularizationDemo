package com.xiongch.lib_common.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.xiongch.lib_common.extensions.observe
import com.xiongch.lib_common.mvvm.BaseViewModel
import com.xiongch.lib_common.mvvm.ViewModelFactory
import javax.inject.Inject

abstract class BaseVMFragment<T : ViewDataBinding, VM : BaseViewModel> : LazyFragment<T>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var mViewModel: VM

    override fun onInitPattern() {
        super.onInitPattern()
        mViewModel = ViewModelProviders.of(this, viewModelFactory)[getViewModelClass()]
        lifecycle.addObserver(mViewModel)
        binding.setLifecycleOwner(this)
        registerLiveData()
    }

    protected abstract fun getViewModelClass(): Class<VM>

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