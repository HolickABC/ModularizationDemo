package com.xiongch.news.di

import com.xiongch.lib_common.di.component.AppComponent
import com.xiongch.lib_common.di.PerApplication
import com.xiongch.news.ui.NewsActivity
import dagger.Component

@PerApplication
@Component(dependencies = [AppComponent::class], modules = [ViewModelModule::class])
interface Injector {

    fun inject(activity: NewsActivity)
}