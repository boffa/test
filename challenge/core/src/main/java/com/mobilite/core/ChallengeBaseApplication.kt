package com.mobilite.core


import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.stetho.BuildConfig
import com.facebook.stetho.Stetho
import com.mobilite.core.di.component.CoreComponent
import com.mobilite.core.di.component.DaggerCoreComponent
import com.mobilite.core.di.module.CoreModule


open class ChallengeBaseApplication : Application() {


    companion object {
        lateinit var coreComponent: CoreComponent
       // var prefs: CoorifySharedPreferences? = null
    }


    override fun onCreate() {
       // prefs = CoorifySharedPreferences(applicationContext)
        super.onCreate()
        initDI()
        initStetho()
        initFresco()
    }

    private fun initDI() {
        coreComponent = DaggerCoreComponent.builder().coreModule(CoreModule(this)).build()
    }


    fun initStetho(){
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }
    fun initFresco(){
        Fresco.initialize(this)
    }

}