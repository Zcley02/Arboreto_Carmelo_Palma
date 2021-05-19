package com.scrummaster.arboretocarmelopalma.di

import android.content.Context
import androidx.room.Room
import com.scrummaster.arboretocarmelopalma.room.TreeDao
import com.scrummaster.arboretocarmelopalma.room.TreeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideTreeDb(@ApplicationContext context: Context): TreeDatabase{
        return Room.databaseBuilder(context, TreeDatabase::class.java, TreeDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideTreeDao(treeDatabase: TreeDatabase): TreeDao{
        return treeDatabase.treeDao()
    }
}