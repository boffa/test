
package com.mobilite.core.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(val  context: Context) {
    @Provides
    @Singleton
    fun providesContext() : Context = context


}