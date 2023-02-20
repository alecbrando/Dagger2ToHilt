package com.example.dagger2tohilt.di

import android.app.Application
import com.example.dagger2tohilt.MainActivity
import com.example.database.di.DatabaseModule
import com.example.network.di.NetworkComponent
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class, DatabaseModule::class], dependencies = [NetworkComponent::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(application: Application): Builder
        fun networkComponent(networkComponent: NetworkComponent): Builder
    }
    fun inject(mainActivity: MainActivity)
    fun inject(application: Application)
}