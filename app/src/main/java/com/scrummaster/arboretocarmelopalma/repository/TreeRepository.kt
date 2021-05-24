package com.scrummaster.arboretocarmelopalma.repository

import com.scrummaster.arboretocarmelopalma.retrofit.NetworkMapper
import com.scrummaster.arboretocarmelopalma.retrofit.TreeRetrofit
import com.scrummaster.arboretocarmelopalma.room.CacheMapper
import com.scrummaster.arboretocarmelopalma.room.TreeDao
import com.scrummaster.arboretocarmelopalma.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class TreeRepository constructor(
    private val treeDao : TreeDao,
    private val treeRetrofit: TreeRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getPlaces(): Flow<DataState> = flow{
        emit(DataState.Loading)
        delay(2000)
        try {
            val treeData = treeRetrofit.get()
            val treeMap = networkMapper.mapFromEntityList(treeData)
            for (tempTree in treeMap){
                treeDao.insert(cacheMapper.mapToEntity(tempTree))
            }
            val cachePla = treeDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachePla)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}