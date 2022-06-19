package com.ajay.roomdbinserapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajay.roomdbinserapp.repository.UserRepository
import com.ajay.roomdbinserapp.roomdatabase.User
import kotlinx.coroutines.launch

class MyViewModel(private val userRepository: UserRepository) : ViewModel() {


    var firstName = MutableLiveData<String?>()
    var lastName = MutableLiveData<String?>()
    var mobileNo = MutableLiveData<String?>()

    var saveData = MutableLiveData<String?>()
    var fetchData = MutableLiveData<String>()

    var updateData = MutableLiveData<String?>()
    var deleteData = MutableLiveData<String?>()

    var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete : User


    //TODO: Initializing values to any button or text view at first time
    init {
        //TODO: Setting value to Mutable Live Data
        saveData.value= "SAVE Data"
        fetchData.value= "Fetch Data"
        updateData.value = "Update data"
        deleteData.value = "Delete Data"

    }
    fun saveDtaOnClick(){

        val fName = firstName.value!!
        val lName = lastName.value!!
        val mobNo = mobileNo.value!!
        insert(User(0, fName, lName, mobNo))
    }

    //TODO: Function to update a particular data from Room database
    fun updateDataOnClick() {
        if (isUpdateOrDelete) {
            userToUpdateOrDelete.firstName = firstName.value!!
            userToUpdateOrDelete.lName = lastName.value!!
            userToUpdateOrDelete.mobileNo = mobileNo.value!!

            update(userToUpdateOrDelete)
            setNullValue()

        }
    }

    //TODO: fetching individual data from room db
    //TODO: Function to set data from database for deleting or updating in Mutable Live Data
    fun updateOrDeleteClick(user: User) {
        //TODO: Here first 'firstName' is the Mutable live data and second 'firstName' is the column
        firstName.value = user.firstName
        lastName.value = user.lName
        mobileNo.value = user.mobileNo

        isUpdateOrDelete = true
        userToUpdateOrDelete = user
    }

    //TODO: Function to delete a particular data from Room database
    fun deleteDataOnClick() {
        if (isUpdateOrDelete) {
            delete(userToUpdateOrDelete)
        }
    }

    private fun insert(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }

    private fun update(user: User) {
        viewModelScope.launch {
            userRepository.update(user)
        }
    }

    private fun delete(user: User) {
        viewModelScope.launch {
            userRepository.delete(user)
        }
    }



    val usersList = userRepository.users

    private fun setNullValue() {
        firstName.value = null
        lastName.value = null
        mobileNo.value = null
    }


}