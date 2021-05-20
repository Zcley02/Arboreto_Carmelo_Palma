package com.scrummaster.arboretocarmelopalma.di

import android.app.Application
import com.scrummaster.arboretocarmelopalma.utils.AdapterTree
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterTree {
        return AdapterTree()
    }
}