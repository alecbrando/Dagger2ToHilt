package com.example.network.di

import android.app.Application
import com.example.network.remote.ApiService
import dagger.BindsInstance
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {
     fun getApiService(): ApiService
    fun inject(application: Application)

    @Component.Builder interface Builder {
        fun build(): NetworkComponent
        @BindsInstance
        fun application(application: Application): Builder
    }
}