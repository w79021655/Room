package com.sample.room.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.room.R
import com.sample.room.data.model.User

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {
    private var mContext: Context? = null
    private var list: MutableList<User> = mutableListOf()

    fun setUsers(list: MutableList<User>) {
        this.list = list
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        mContext = parent.context.applicationContext
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cell_user, parent, false)
        return UsersViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = list[position]
        holder.id.text = mContext!!.getString(R.string.id) + user.id.toString()
        holder.name.text = mContext!!.getString(R.string.name) + user.name.toString()
        holder.age.text = mContext!!.getString(R.string.age) + user.age.toString()
    }

    inner class UsersViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var id: TextView = itemView!!.findViewById(R.id.id)
        var name: TextView = itemView!!.findViewById(R.id.name)
        var age: TextView = itemView!!.findViewById(R.id.age)
    }
}