package com.xiongch.lib_common.api

import com.xiongch.lib_common.api.repository.TestRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTestRepository(retrofit: Retrofit): TestRepository {
        return TestRepository(retrofit)
    }
}