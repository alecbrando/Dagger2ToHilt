package com.example.dagger2tohilt.util

import android.app.Application
import com.example.dagger2tohilt.di.AppComponent

//internal object FeatureComponentHolder: LazyWithConstructorHolder<Application, AppComponent>({ app ->
//    val coreComponent = requireNotNull(app as? Core).provideCoreComponent()
//    DaggerAppComponent.factory().createComponent(coreComponent)
//})
//
//
//
//
//open class LazyWithConstructorHolder<in A, out T>(creator: (A) -> T){
//    private var creator: ((A) -> T)? = creator
//    @Volatile private var instance: T? = null
//    fun getInstance(arg: A): T {
//        val i = instance
//        if (i != null) {
//            return i
//        }
//        return synchronized(this) {
//            val i2 = instance
//            if (i2 != null) {
//                i2
//            } else {
//                val created = creator!!(arg)
//                instance = created
//                creator = null
//                created
//            }
//        }
//    }
//}