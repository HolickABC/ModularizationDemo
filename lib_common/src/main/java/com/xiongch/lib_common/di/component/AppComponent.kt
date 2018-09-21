package com.xiongch.lib_common.di.component

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.xiongch.lib_common.di.module.AppModule
import com.xiongch.lib_common.di.module.NetworkModule
import com.xiongch.lib_common.api.RepositoryModule
import com.xiongch.lib_common.api.repository.TestRepository
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class])
interface AppComponent {

    fun getApplication(): Application

    fun getApplicationContext(): Context

    fun getOkHttpClient(): OkHttpClient

    fun getRetrofit(): Retrofit

    fun getGsonFactory(): GsonConverterFactory

    fun getGson(): Gson

    fun getTestRepository(): TestRepository

}