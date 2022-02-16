package com.rakhman.jsonplaceholder.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakhman.jsonplaceholder.ui.model.PostModel
import com.rakhman.jsonplaceholder.ui.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myresponse : MutableLiveData<Response<PostModel>> = MutableLiveData()
    var myCustomPosts: MutableLiveData<Response<List<PostModel>>> = MutableLiveData()


    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myresponse.value = response
        }
    }

    fun getCustomPosts(userId: Int, sort: String, order: String){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order)
            myCustomPosts.value = response
        }
    }

}