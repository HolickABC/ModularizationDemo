package com.xiongch.girl.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.xiongch.lib_common.navigator.ARouterPath
import com.xiongch.lib_common.base.BaseVMActivity
import com.xiongch.girl.GirlsApplication
import com.xiongch.girl.R
import com.xiongch.girl.databinding.ActivityGirlBinding

@Route(path = ARouterPath.GIRL_ACTIVITY)
class GirlActivity : BaseVMActivity<ActivityGirlBinding, GirlActViewModel>() {

    override fun getLayoutRes() = R.layout.activity_girl

    override fun onInitDagger() {
        super.onInitDagger()
        GirlsApplication.injector.inject(this)
    }

    override fun getViewModelClass(): Class<GirlActViewModel>  = GirlActViewModel::class.java

    override fun onInitViews() {
        super.onInitViews()
        mViewModel.test {

        }
    }
}
