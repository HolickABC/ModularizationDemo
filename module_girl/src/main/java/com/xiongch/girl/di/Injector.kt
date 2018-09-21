package com.xiongch.girl.di

import com.xiongch.lib_common.di.component.AppComponent
import com.xiongch.lib_common.di.PerApplication
import com.xiongch.girl.ui.GirlActivity
import dagger.Component

@PerApplication
@Component(dependencies = [AppComponent::class], modules = [ViewModelModule::class])
interface Injector {

    fun inject(activity: GirlActivity)
}