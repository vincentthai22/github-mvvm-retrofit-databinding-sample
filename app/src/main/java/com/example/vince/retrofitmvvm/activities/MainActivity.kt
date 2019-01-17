package com.example.vince.retrofitmvvm.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.vince.retrofitmvvm.R
import com.example.vince.retrofitmvvm.adapters.MainRecyclerAdapter
import com.example.vince.retrofitmvvm.databinding.ActivityMainBinding
import com.example.vince.retrofitmvvm.models.User
import com.example.vince.retrofitmvvm.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: MainRecyclerAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        setupRecyclerView()
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModel::class.java)
//        viewModel.usersMutableLiveData.observe(this, userObserver)
        binding.viewModel = viewModel
        viewModel.notifyViewModelOnCreate()
    }

    private fun setupRecyclerView() {
        val adapter = MainRecyclerAdapter(this)
        recyclerView = mainRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerAdapter = adapter
    }

    val userObserver = Observer<List<User>> {
        Toast.makeText(this, "Yo it worked", Toast.LENGTH_LONG).show()
        it?.let { userList ->
            recyclerAdapter.users = ArrayList(userList)
        }
    }


}
