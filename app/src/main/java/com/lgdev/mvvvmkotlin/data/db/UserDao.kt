package com.lgdev.mvvvmkotlin.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lgdev.mvvvmkotlin.data.db.entities.CURRENT_USER_ID
import com.lgdev.mvvvmkotlin.data.db.entities.User

//DAO == Data Access Object
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upSert(user: User): Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>

}