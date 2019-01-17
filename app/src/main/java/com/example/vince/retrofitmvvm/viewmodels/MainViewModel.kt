package com.example.vince.retrofitmvvm.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.Bindable
import com.example.vince.retrofitmvvm.datasource.RetrofitManager
import com.example.vince.retrofitmvvm.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(app: Application) : AndroidViewModel(app) {

    val usersMutableLiveData = MutableLiveData<List<User>>()

    fun notifyViewModelOnCreate() {
        val service = RetrofitManager.getInstance().getListOfAllUsersNetworkCall()
        service.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                throw Exception("blah")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                usersMutableLiveData.value = response.body()
            }
        })
    }


}