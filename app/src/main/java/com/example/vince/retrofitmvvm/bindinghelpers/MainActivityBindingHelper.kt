package com.example.vince.retrofitmvvm.bindinghelpers

import android.arch.lifecycle.MutableLiveData
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.vince.retrofitmvvm.adapters.MainRecyclerAdapter
import com.example.vince.retrofitmvvm.models.User

class MainActivityBindingHelper {

    companion object {

        @BindingAdapter("mainList")
        @JvmStatic
        fun setMainActivityList(recyclerView: RecyclerView, users: List<User>?) {
            (recyclerView.adapter as? MainRecyclerAdapter)?.let {
                (users as? ArrayList<User>)?.let { nonNullList ->
                    it.users = nonNullList
                    it.notifyDataSetChanged()
                }
            }
        }

    }

}