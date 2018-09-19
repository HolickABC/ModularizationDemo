package com.xiongch.module_girl

import android.app.Application
import android.content.Context
import android.util.Log
import com.xiongch.lib_common.module.IAppLife
import com.xiongch.lib_common.module.IModuleConfig

class GirlsApplication : IModuleConfig, IAppLife {
    override fun injectAppLifecycle(context: Context?, iAppLifes: MutableList<IAppLife>?) {
        iAppLifes?.add(this)
    }

    override fun injectActivityLifecycle(context: Context?, lifecycleCallbackses: MutableList<Application.ActivityLifecycleCallbacks>?) {

    }

    override fun attachBaseContext(base: Context?) {

    }

    override fun onCreate(application: Application?) {
        Log.i("test", "GirlsApplication onCreate()")
    }

    override fun onTerminate(application: Application?) {

    }

}