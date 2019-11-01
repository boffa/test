
package com.mobilite.challenge.di.component

import com.mobilite.challenge.ui.MainFragment
import com.mobilite.core.di.component.CoreComponent
import com.mobilite.challenge.di.module.AppModule
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class  AppScope

@AppScope
@Component(modules = [AppModule::class],dependencies = [CoreComponent::class])
interface AppComponent {
    fun inject(mainFragment: MainFragment)

}