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

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    open lateinit var binding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ARouter.getInstance().inject(this)
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        onInitViews()
        return binding.root
    }

    open fun onInitViews() {}

    @LayoutRes
    protected abstract fun getLayoutRes(): Int
}