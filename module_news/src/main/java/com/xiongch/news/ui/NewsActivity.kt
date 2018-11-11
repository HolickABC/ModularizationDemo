package com.xiongch.news.ui

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiongch.lib_common.base.BaseVMActivity
import com.xiongch.lib_common.extensions.toast
import com.xiongch.lib_common.navigator.ARouterPath
import com.xiongch.news.NewsApplication
import com.xiongch.news.R
import com.xiongch.news.databinding.ActivityNewsBinding

@Route(path = ARouterPath.NEWS_ACTIVITY)
class NewsActivity : BaseVMActivity<ActivityNewsBinding, NewsActViewModel>() {

    @Autowired
    @JvmField var url: String? = null

    override fun getLayoutRes() = R.layout.activity_news

    override fun onInitDagger() {
        super.onInitDagger()
        NewsApplication.injector.inject(this)
    }

    override fun getViewModelClass(): Class<NewsActViewModel> = NewsActViewModel::class.java

    override fun onInitViews() {
        super.onInitViews()
        toast(url)
    }

}
