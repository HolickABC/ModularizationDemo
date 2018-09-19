package com.xiongch.lib_common.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.xiongch.lib_common.BuildConfig

open class BaseApplication : Application() {

    private lateinit var applicationDelegate: ApplicationDelegate

    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        lateinit var INSTANCE : Context
            private set
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        applicationDelegate = ApplicationDelegate()
        applicationDelegate.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        applicationDelegate.onCreate(this)
        INSTANCE = this
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        applicationDelegate.onTerminate(this)
    }
}