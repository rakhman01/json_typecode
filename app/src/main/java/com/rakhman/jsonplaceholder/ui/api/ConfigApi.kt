package com.rakhman.jsonplaceholder.ui.api

import com.rakhman.jsonplaceholder.ui.model.PostModel
import retrofit2.Response
import retrofit2.http.*

interface ConfigApi {
    @GET("post/1")
    suspend fun getPost(): Response<PostModel>

    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<PostModel>>

    @PATCH("posts/1")
    suspend fun postData(
        @Body post: PostModel
//        @Field("userId") userId : Int,
//        @Field("title") title : String,
//        @Field("body") body : String,
//        @Field("id") id : String
    ): Response<PostModel>
}