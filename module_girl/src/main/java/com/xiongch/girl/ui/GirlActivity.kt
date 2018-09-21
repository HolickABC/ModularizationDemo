package com.xiongch.girl.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.xiongch.lib_common.navigator.ARouterPath
import com.xiongch.lib_common.base.BaseVMActivity
import com.xiongch.lib_common.extensions.observe
import com.xiongch.lib_common.extensions.withViewModel
import com.xiongch.lib_common.mvvm.ViewModelFactory
import com.xiongch.girl.GirlsApplication
import com.xiongch.girl.R
import com.xiongch.girl.databinding.ActivityGirlBinding
import javax.inject.Inject

@Route(path = ARouterPath.GIRL_ACTIVITY)
class GirlActivity : BaseVMActivity<ActivityGirlBinding, GirlActViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun getLayoutRes() = R.layout.activity_girl

    override fun onInitDagger() {
        super.onInitDagger()
        GirlsApplication.injector.inject(this)
    }
    override fun getViewModel(): GirlActViewModel {
        return withViewModel(viewModelFactory) {
            observe(test) {}
        }
    }

    override fun onInitViews() {
        super.onInitViews()
        mViewModel.test {

        }
    }
}
