package com.xiongch.lib_common.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.core.app.ActivityCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.barlibrary.ImmersionBar
import com.xiongch.lib_common.R
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: T

    private lateinit var mImmersionBar: ImmersionBar

    protected val mDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        if (isPlayWindowAnimation()) {
            showEnterAnim()
        } else {
            hideActivityAnim()
        }
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        onInitDagger()
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        if (isImmersionBarEnabled()) {
            initImmersionBar()
        }
        onInitPattern()
        onInitViews()
    }

    protected open fun onInitPattern() {}

    protected open fun onInitViews() {}

    protected open fun onInitDagger() {}

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected open fun isPlayWindowAnimation(): Boolean {
        return true
    }

    private fun showEnterAnim() {
        overridePendingTransition(R.anim.activity_up_in, R.anim.activity_up_out)
    }

    private fun showExitAnim() {
        overridePendingTransition(R.anim.activity_down_in, R.anim.activity_down_out)
    }

    private fun hideActivityAnim() {
        overridePendingTransition(0, 0)
    }

    override fun finish() {
        super.finish()
        if (isPlayWindowAnimation()) {
            showExitAnim()
        } else {
            hideActivityAnim()
        }
    }

    private fun isImmersionBarEnabled(): Boolean {
        return true
    }

    protected open fun initImmersionBar() {
        //注意： keyboardEnable会导致在7.0中将app缩小时键盘展示在下方   界面多了个键盘高度
        mImmersionBar = ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.3f)
                .keyboardEnable(true)
        mImmersionBar.init()
    }

    override fun onDestroy() {
        mImmersionBar.destroy()
        mDisposable.clear()
        super.onDestroy()
    }

    protected fun setUpToolbar(toolbar: Toolbar?) {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.let {
                it.setDisplayShowTitleEnabled(true)
                it.setDisplayHomeAsUpEnabled(true)
                it.setHomeAsUpIndicator(R.drawable.icon_back)
            }
        }
    }

    protected fun setActionbarTitle(str: String) {
        supportActionBar?.let {
            it.title = str
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            ActivityCompat.finishAfterTransition(this)
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun showLoading() {}

    protected fun dismissLoading() {}

}