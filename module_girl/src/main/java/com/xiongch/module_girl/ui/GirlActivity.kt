package com.xiongch.module_girl.ui

import android.support.v4.content.ContextCompat
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiongch.lib_common.base.ARouterPath
import com.xiongch.lib_common.base.BaseActivity
import com.xiongch.module_girl.R
import com.xiongch.module_girl.databinding.ActivityGirlBinding

@Route(path = ARouterPath.GIRL_ACTIVITY)
class GirlActivity : BaseActivity<ActivityGirlBinding>() {

    override fun getLayoutRes() = R.layout.activity_girl

    override fun onInitViews() {
        super.onInitViews()
        Log.i("test", "test string --> ${resources.getString(R.string.app_name)}")
        Log.i("test", "test color --> ${ContextCompat.getColor(this, R.color.colorPrimary)}")
    }
}
