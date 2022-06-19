package com.ajay.roomdbinserapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajay.roomdbinserapp.databinding.DisplayItemsBinding
import com.ajay.roomdbinserapp.roomdatabase.User

class MyRecyclerViewAdapter(private val userList: List<User>,private var selectedItem : (User) -> Unit) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DisplayItemsBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position],selectedItem)
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    inner class MyViewHolder(val binding: DisplayItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User,selectedItem : (User) -> Unit) {
            binding.yourName.text = user.firstName+" "+user.lName
            binding.mobileNumber.text = user.mobileNo
            // for selecting particular data items
            binding.rootItem.setOnClickListener {
                selectedItem(user)
            }

        }
    }



}