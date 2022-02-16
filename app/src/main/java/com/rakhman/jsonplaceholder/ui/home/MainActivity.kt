package com.rakhman.jsonplaceholder.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakhman.jsonplaceholder.R
import com.rakhman.jsonplaceholder.ui.adapter.MyAdapter
import com.rakhman.jsonplaceholder.ui.repository.Repository

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private val myAdapter by lazy {
        MyAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyckerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCustomPosts(5,"id","desc")
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyckerview() {
        val parent = findViewById<RecyclerView>(R.id.recyclerView)
        parent.adapter = myAdapter
        parent.layoutManager =  LinearLayoutManager(this)
    }
}