package com.ajay.roomdbinserapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ajay.roomdbinserapp.repository.UserRepository
import com.ajay.roomdbinserapp.viewmodel.MyViewModel
import java.lang.IllegalArgumentException

class UserViewModelFactory(val userRepository: UserRepository): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(userRepository) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}