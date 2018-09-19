package com.xiongch.module_girl.ui


import android.support.v4.content.ContextCompat
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiongch.lib_common.base.ARouterPath
import com.xiongch.lib_common.base.BaseFragment
import com.xiongch.module_girl.R
import com.xiongch.module_girl.databinding.FragmentGirlBinding

@Route(path = ARouterPath.GIRL_FRAGMENT)
class GirlFragment : BaseFragment<FragmentGirlBinding>() {

    override fun getLayoutRes() = R.layout.fragment_girl

    override fun onInitViews() {
        super.onInitViews()
    }

}
