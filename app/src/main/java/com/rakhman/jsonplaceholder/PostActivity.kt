package com.rakhman.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rakhman.jsonplaceholder.ui.home.MainViewModel
import com.rakhman.jsonplaceholder.ui.home.MainViewModelFactory
import com.rakhman.jsonplaceholder.ui.model.PostModel
import com.rakhman.jsonplaceholder.ui.repository.Repository

class PostActivity : AppCompatActivity() {
    private var TAG: String = "PostActivity"
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val myPost = PostModel(2,2,"coba","Kotlin Dev")
        viewModel.pushPost(myPost)

        viewModel.myresponse.observe(this, Observer { response ->
            if (response.isSuccessful){
                log(response.body().toString())
                log("sucessful")
            }else{
                log("error")
                Toast.makeText(this,response.code(),Toast.LENGTH_SHORT).show()
            }
        })

    }
    private fun log(message: String){
        Log.d(TAG,message)
    }
}