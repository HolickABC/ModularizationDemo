package com.xiongch.lib_common.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    open lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        onInitViews()
    }

    open fun onInitViews() {}

    @LayoutRes
    protected abstract fun getLayoutRes(): Int
}