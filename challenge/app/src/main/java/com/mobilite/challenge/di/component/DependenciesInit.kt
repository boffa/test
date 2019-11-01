
package com.mobilite.challenge.di.component

import com.mobilite.core.ChallengeBaseApplication
import javax.inject.Singleton

@Singleton
object DependenciesInit {
    private var appComponent : AppComponent? = null

    fun appComponent() : AppComponent {
        if (appComponent == null)
            appComponent = DaggerAppComponent.builder().coreComponent(ChallengeBaseApplication.coreComponent).build()

        return appComponent as AppComponent
    }

    fun destroyDaggerAppComponent(){
        appComponent == null
    }
}