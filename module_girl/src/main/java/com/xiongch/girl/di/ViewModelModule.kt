package com.xiongch.girl.di

import androidx.lifecycle.ViewModel
import com.xiongch.lib_common.di.ViewModelKey
import com.xiongch.girl.ui.GirlActViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap()
    @ViewModelKey(GirlActViewModel::class)
    abstract fun girlActViewModel(viewModel: GirlActViewModel): ViewModel
}