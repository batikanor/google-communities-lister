package com.batikanor.google.communitieslister.data

import com.batikanor.google.communitieslister.data.model.Community
import retrofit2.http.GET

interface CommunitiesMockApi {
    @GET("communities")
    suspend fun getCommunities(): List<Community>
}