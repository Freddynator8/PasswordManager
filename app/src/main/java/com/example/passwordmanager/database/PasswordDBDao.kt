package com.example.passwordmanager.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PasswordDBDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPassword(item: PasswordDBDefinition)

    @Update
    suspend fun updatePassword(item: PasswordDBDefinition)

    @Delete
    suspend fun deletePassword(item: PasswordDBDefinition)

    @Query("DELETE FROM password_table_v1")
    suspend fun deleteAllPasswords()

    @Query("SELECT * FROM password_table_v1")
    fun readAllPasswords(): LiveData<List<PasswordDBDefinition>>

}