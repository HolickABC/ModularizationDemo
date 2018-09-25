package com.xiongch.news.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xiongch.lib_common.di.ViewModelKey
import com.xiongch.lib_common.mvvm.ViewModelFactory
import com.xiongch.news.ui.NewsActViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap()
    @ViewModelKey(NewsActViewModel::class)
    abstract fun newsActViewModel(viewModel: NewsActViewModel): ViewModel
}