package com.xiongch.module_news.ui

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiongch.lib_common.base.ARouterPath
import com.xiongch.lib_common.base.BaseActivity
import com.xiongch.lib_common.extensions.toast
import com.xiongch.module_news.R
import com.xiongch.module_news.databinding.ActivityNewsBinding

@Route(path = ARouterPath.NEWS_ACTIVITY)
class NewsActivity : BaseActivity<ActivityNewsBinding>() {

    @Autowired
    @JvmField var url: String? = null

    override fun getLayoutRes() = R.layout.activity_news

    override fun onInitViews() {
        super.onInitViews()
        toast(url)
    }

}
