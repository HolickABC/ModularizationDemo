package com.xiongch.lib_common.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.xiongch.lib_common.BuildConfig
import com.xiongch.lib_common.di.component.AppComponent
import com.xiongch.lib_common.di.module.AppModule
import com.xiongch.lib_common.di.component.DaggerAppComponent

open class BaseApplication : Application() {

    private lateinit var applicationDelegate: ApplicationDelegate

    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        lateinit var INSTANCE: Context
            private set

        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        applicationDelegate = ApplicationDelegate()
        applicationDelegate.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()
        }
        ARouter.init(this)
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        applicationDelegate.onCreate(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        applicationDelegate.onTerminate(this)
    }
}