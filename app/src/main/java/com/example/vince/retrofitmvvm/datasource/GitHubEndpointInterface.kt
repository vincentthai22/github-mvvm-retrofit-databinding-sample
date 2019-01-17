package com.example.vince.retrofitmvvm.datasource

import com.example.vince.retrofitmvvm.models.Repo
import com.example.vince.retrofitmvvm.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubEndpointInterface {

    @GET("users")
    fun getAllUsers(): Call<List<User>>

    @GET("users/{username}")
    fun getUser(@Path("username") userName: String): Call<User>

    @GET("users/{username}/repos")
    fun getUserRepos(@Path("username") userName: String): Call<List<Repo>>

}