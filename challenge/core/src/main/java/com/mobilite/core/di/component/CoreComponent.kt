
package com.mobilite.core.di.component

import android.content.Context
import android.content.SharedPreferences
import com.mobilite.core.CoreService
import com.mobilite.core.ServiceHolder
import com.mobilite.core.di.module.CoreModule
import com.mobilite.core.di.module.NetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, NetworkModule::class])
interface CoreComponent {

    fun context(): Context

    fun retrofit(): Retrofit

    fun apiService(): CoreService

    fun serviceHolder(): ServiceHolder

    //fun sharedPreferences(): SharedPreferences
}