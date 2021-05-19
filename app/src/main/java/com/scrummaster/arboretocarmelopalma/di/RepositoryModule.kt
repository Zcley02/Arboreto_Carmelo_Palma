package com.scrummaster.arboretocarmelopalma.di

import com.scrummaster.arboretocarmelopalma.repository.TreeRepository
import com.scrummaster.arboretocarmelopalma.retrofit.NetworkMapper
import com.scrummaster.arboretocarmelopalma.retrofit.TreeRetrofit
import com.scrummaster.arboretocarmelopalma.room.CacheMapper
import com.scrummaster.arboretocarmelopalma.room.TreeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent :: class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTreeRepository(
        treeDao: TreeDao,
        treeRetrofit: TreeRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): TreeRepository{
        return TreeRepository(treeDao, treeRetrofit, cacheMapper, networkMapper)
    }
}