package com.ajay.roomdbinserapp.repository

import com.ajay.roomdbinserapp.roomdatabase.User
import com.ajay.roomdbinserapp.roomdatabase.UserDao

class UserRepository(val dao: UserDao) {

    //TODO: Insert function called
    suspend fun insert(user : User) {
        dao.insertUser(user)
    }


    //TODO: Fetching function called
    val users = dao.getUsers()


    // Todo : Delete all Data
    //TODO: Delete function called
    suspend fun delete(user: User) {
        dao.deleteUser(user)
    }

    suspend fun update(user: User) {
        dao.updateUser(user)

    }
}