package com.xiongch.specific.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.alibaba.android.arouter.launcher.ARouter
import com.xiongch.lib_common.navigator.ARouterPath
import com.xiongch.lib_common.base.BaseActivity
import com.xiongch.specific.R
import com.xiongch.specific.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mFragments = ArrayList<Fragment>()

    override fun getLayoutRes() = R.layout.activity_main

    override fun onInitViews() {
        super.onInitViews()
        mFragments.apply {
            add(ARouter.getInstance().build(ARouterPath.GIRL_FRAGMENT).navigation() as Fragment)
            add(ARouter.getInstance().build(ARouterPath.NEWS_FRAGMENT).navigation() as Fragment)
        }
        binding.bottom.setOnNavigationItemSelectedListener { item ->
            val i = item.itemId
            if (i == R.id.navigation_girl) {
                binding.viewPager.currentItem = 0
                return@setOnNavigationItemSelectedListener true
            } else if (i == R.id.navigation_news) {
                binding.viewPager.currentItem = 1
                return@setOnNavigationItemSelectedListener true
            }
            return@setOnNavigationItemSelectedListener false
        }
        binding.viewPager.offscreenPageLimit = mFragments.size
        val adapter = FragmentAdapter(supportFragmentManager, mFragments)
        binding.viewPager.adapter = adapter
    }

    inner class FragmentAdapter(fm: FragmentManager, private val mFragments: List<Fragment>?) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return mFragments!![position]
        }

        override fun getCount(): Int {
            return mFragments?.size ?: 0
        }

        override fun getItemPosition(`object`: Any): Int {
            return super.getItemPosition(`object`)
        }
    }
}
