package com.xiongch.news

import android.app.Application
import android.content.Context
import android.util.Log
import com.xiongch.lib_common.base.BaseApplication
import com.xiongch.lib_common.module.IAppLife
import com.xiongch.lib_common.module.IModuleConfig
import com.xiongch.news.di.DaggerInjector
import com.xiongch.news.di.Injector

class NewsApplication : IModuleConfig, IAppLife {

    companion object {
        lateinit var injector: Injector private set
    }

    override fun injectAppLifecycle(context: Context?, iAppLifes: MutableList<IAppLife>?) {
        iAppLifes?.add(this)
    }

    override fun injectActivityLifecycle(context: Context?, lifecycleCallbackses: MutableList<Application.ActivityLifecycleCallbacks>?) {
    }

    override fun attachBaseContext(base: Context?) {
    }

    override fun onCreate(application: Application?) {
        Log.i("test", "NewsApplication onCreate()")
        initDagger2(application)
    }

    private fun initDagger2(application: Application?) {
        injector = DaggerInjector.builder().appComponent(BaseApplication.appComponent).build()
    }

    override fun onTerminate(application: Application?) {
    }
}