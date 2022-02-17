package com.rakhman.jsonplaceholder.ui.repository

import com.rakhman.jsonplaceholder.ui.api.RetrofitInstance
import com.rakhman.jsonplaceholder.ui.model.PostModel
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<PostModel>{
        return RetrofitInstance.api.getPost()
    }

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<PostModel>> {
        return RetrofitInstance.api.getCustomPosts(userId, sort, order)
    }

    suspend fun pushpost(post: PostModel): Response<PostModel>{
        return RetrofitInstance.api.postData(post)
    }
}