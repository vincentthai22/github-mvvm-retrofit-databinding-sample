package com.example.vince.retrofitmvvm.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vince.retrofitmvvm.R
import com.example.vince.retrofitmvvm.activities.MainActivity
import com.example.vince.retrofitmvvm.databinding.RecyclerMainBinding
import com.example.vince.retrofitmvvm.models.User
import kotlinx.android.synthetic.main.recycler_main.view.*

class MainRecyclerAdapter(var activity:MainActivity): RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {

    var users = ArrayList<User>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.recycler_main, parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(viewHolder: MainViewHolder, index: Int) {
        viewHolder.binding.user = users[index]
        viewHolder.binding.executePendingBindings()
//        val user = users[index]
//        viewHolder.infoTextView.text = String.format("%s\n%s\n%s\n%s", user.username, user.avatarUrl, user.gitHubUrl, user.repoCount)
    }

    inner class MainViewHolder(var binding: RecyclerMainBinding): RecyclerView.ViewHolder(binding.root) {
        var infoTextView = itemView.githubInfoTextView
        init {

        }
    }
}