package com.xiongch.news.ui


import com.alibaba.android.arouter.facade.annotation.Route
import com.xiongch.lib_common.navigator.ARouterPath
import com.xiongch.lib_common.base.BaseFragment
import com.xiongch.news.R
import com.xiongch.news.databinding.FragmentNewsBinding

@Route(path = ARouterPath.NEWS_FRAGMENT)
class NewsFragment : BaseFragment<FragmentNewsBinding>() {

    override fun getLayoutRes() = R.layout.fragment_news

}
