package com.xiongch.module_news.ui


import com.alibaba.android.arouter.facade.annotation.Route
import com.xiongch.lib_common.base.ARouterPath
import com.xiongch.lib_common.base.BaseFragment
import com.xiongch.module_news.R
import com.xiongch.module_news.databinding.FragmentNewsBinding

@Route(path = ARouterPath.NEWS_FRAGMENT)
class NewsFragment : BaseFragment<FragmentNewsBinding>() {

    override fun getLayoutRes() = R.layout.fragment_news

}
