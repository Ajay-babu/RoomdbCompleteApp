package com.ajay.roomdbinserapp.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User) : Long

    @Query("SELECT * FROM user_table")
    fun getUsers() : LiveData<List<User>>

    @Delete()
    suspend fun deleteUser(user: User)

    @Update()
    suspend fun updateUser(user: User)
}