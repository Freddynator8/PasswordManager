package com.example.passwordmanager.database

import androidx.lifecycle.LiveData

class PasswordDBRepository(private val passwordDao: PasswordDBDao) {

    val readAllPasswords: LiveData<List<PasswordDBDefinition>> = passwordDao.readAllPasswords()

    suspend fun addPassword(item: PasswordDBDefinition){
        passwordDao.addPassword(item)
    }

    suspend fun updatePassword(item: PasswordDBDefinition){
        passwordDao.updatePassword(item)
    }

    suspend fun deletePassword(item: PasswordDBDefinition){
        passwordDao.deletePassword(item)
    }

    suspend fun deleteAllPasswords(){
        passwordDao.deleteAllPasswords()
    }


}