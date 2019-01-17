package com.example.vince.retrofitmvvm.models

import com.google.gson.annotations.SerializedName

class User {

    var id: String = ""

    @SerializedName("login")
    var username = ""

    @SerializedName("avatar_url")
    var avatarUrl: String = ""

    @SerializedName("url")
    var gitHubUrl: String = ""

    @SerializedName("public_repos")
    var repoCount = 0



}