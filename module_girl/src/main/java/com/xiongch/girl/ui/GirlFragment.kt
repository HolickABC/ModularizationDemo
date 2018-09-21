package com.xiongch.girl.ui


import com.alibaba.android.arouter.facade.annotation.Route
import com.xiongch.lib_common.navigator.ARouterPath
import com.xiongch.lib_common.base.BaseFragment
import com.xiongch.girl.R
import com.xiongch.girl.databinding.FragmentGirlBinding

@Route(path = ARouterPath.GIRL_FRAGMENT)
class GirlFragment : BaseFragment<FragmentGirlBinding>() {

    override fun getLayoutRes() = R.layout.fragment_girl

    override fun onInitViews() {
        super.onInitViews()
    }

}
