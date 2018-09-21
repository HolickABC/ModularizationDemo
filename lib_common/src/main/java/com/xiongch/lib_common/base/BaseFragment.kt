package com.xiongch.lib_common.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    protected lateinit var binding: T

    protected val mDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ARouter.getInstance().inject(this)
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        onInitPattern()
        onInitViews()
        return binding.root
    }

    protected open fun onInitPattern() {}

    protected open fun onInitViews() {}

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    override fun onDestroy() {
        mDisposable.clear()
        super.onDestroy()
    }

    protected fun showLoading() {}

    protected fun dismissLoading() {}
}