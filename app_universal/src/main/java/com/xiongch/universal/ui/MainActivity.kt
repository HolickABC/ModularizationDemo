package com.xiongch.universal.ui

import android.content.Intent
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.xiongch.lib_common.base.ARouterPath
import com.xiongch.lib_common.base.BaseActivity
import com.xiongch.universal.R
import com.xiongch.universal.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutRes() = R.layout.activity_main

    override fun onInitViews() {
        super.onInitViews()
        binding.btnGirl.setOnClickListener {
            ARouter.getInstance()
                    .build(ARouterPath.GIRL_ACTIVITY)
                    .withTransition(R.anim.activity_up_in, R.anim.activity_up_out)
                    .navigation(this)
        }
        binding.btnNews.setOnClickListener {
            ARouter.getInstance()
                    .build(ARouterPath.NEWS_ACTIVITY)
                    .withString("url", "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1")
                    .withTransition(R.anim.activity_up_in, R.anim.activity_up_out)
                    .navigation(this, 2, object : NavigationCallback {
                        override fun onLost(postcard: Postcard?) {
                            Log.i("test", "ARouter onLost 没有匹配到跳转路径")
                        }

                        override fun onFound(postcard: Postcard?) {
                            Log.i("test", "ARouter onFound 找到跳转匹配路径")
                        }

                        override fun onInterrupt(postcard: Postcard?) {
                            Log.i("test", "ARouter onInterrupt 跳转被中断")
                        }

                        override fun onArrival(postcard: Postcard?) {
                            Log.i("test", "ARouter onArrival 成功跳转")
                        }
                    })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
