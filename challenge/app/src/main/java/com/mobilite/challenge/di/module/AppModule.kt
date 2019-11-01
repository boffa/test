
package com.mobilite.di.module

import com.mobilite.challenge.factory.MainViewModelFactory
import com.mobilite.core.CoreService
import com.mobilite.core.data.PhotoDataSourceImpl
import com.mobilite.core.data.PhotoRepositoryImpl
import com.mobilite.core.utils.AppExecutors
import com.mobilite.di.component.AppScope
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ObsoleteCoroutinesApi
import retrofit2.Retrofit

class AppModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): CoreService {
        return retrofit.create(CoreService::class.java)
    }

    @Provides
    @AppScope
    fun providePhotosRepository(api: CoreService, appExecutors: AppExecutors): PhotoRepositoryImpl {
        val userDataSource = PhotoDataSourceImpl(api, appExecutors)
        return PhotoRepositoryImpl(userDataSource)
    }

    @ObsoleteCoroutinesApi
    @Provides
    @AppScope
    fun provideAppExecuters(): AppExecutors {
        return AppExecutors()
    }

    @Provides
    @AppScope
    fun provideMainViewModelFactory(photoRepository: PhotoRepositoryImpl): MainViewModelFactory {
        return MainViewModelFactory(photoRepository)
    }

}