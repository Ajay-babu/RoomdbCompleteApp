package com.ajay.roomdbinserapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ajay.roomdbinserapp.R
import com.ajay.roomdbinserapp.databinding.ActivityMainBinding
import com.ajay.roomdbinserapp.factory.UserViewModelFactory
import com.ajay.roomdbinserapp.repository.UserRepository
import com.ajay.roomdbinserapp.roomdatabase.UserDatabase
import com.ajay.roomdbinserapp.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        //TODO: for fetching data into display activity
        binding.dataShowBtn.setOnClickListener {
            startActivity(Intent(this,DisplayActivity::class.java))
        }

        //TODO: Initializing all the MVVM concepts used here
        val dao = UserDatabase.getInstance(this).dao
        val userRepository = UserRepository(dao)
        val factory = UserViewModelFactory(userRepository)
        myViewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]

        //TODO: Giving lifecycle owner to layout file
        binding.viewmodel = myViewModel

        //TODO: Giving lifecycle owner to layout file
        binding.lifecycleOwner = this
    }
}