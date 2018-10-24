package com.xiongch.lib_common.di.module

import androidx.lifecycle.ViewModelProvider
import com.xiongch.lib_common.mvvm.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}