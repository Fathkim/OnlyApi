package com.fathkim.onlyapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fathkim.onlyapi.data.ItemUserResponse
import com.fathkim.onlyapi.databinding.ItemUsersBinding

class AdapterUser: RecyclerView.Adapter<AdapterUser.UserViewHolder>() {
    private val listUser = ArrayList<ItemUserResponse>()
    class UserViewHolder(val itemUser: ItemUsersBinding): RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  UserViewHolder (
        ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemUser.apply {
            with(listUser[position]){
                Textid.text = id.toString() //toString berguna untuk mengubah tipe data dari Int ke String
                Textname.text = name
                Textemail.text = email
            }
        }
    }

    override fun getItemCount(): Int = listUser.size

        fun setUser(user: ArrayList<ItemUserResponse>){
            this.listUser.clear()
            this.listUser.addAll(user)
        }
}