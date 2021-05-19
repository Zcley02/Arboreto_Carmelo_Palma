package com.scrummaster.arboretocarmelopalma.retrofit

import retrofit2.http.GET

interface TreeRetrofit {
    @GET("games")
    suspend fun get () : List<TreeNetworkEntity>
}