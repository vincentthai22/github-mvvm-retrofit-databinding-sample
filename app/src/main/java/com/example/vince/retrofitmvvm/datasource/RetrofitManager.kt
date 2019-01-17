package com.example.vince.retrofitmvvm.datasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {

        companion object {
            const val BASE_URL = "https://api.github.com/"
            lateinit var retrofit: Retrofit
            private var ourInstance: RetrofitManager? = null

            fun getInstance(): RetrofitManager {
                if(ourInstance == null) {
                    synchronized(RetrofitManager::class.java) {
                        ourInstance = RetrofitManager()
                    }
                }
                return ourInstance!!
            }
        }

    init {
        initializeRetrofit()
    }

    private fun initializeRetrofit(){
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    fun getListOfAllUsersNetworkCall(): GitHubEndpointInterface {
        return retrofit.create(GitHubEndpointInterface::class.java)
    }

}