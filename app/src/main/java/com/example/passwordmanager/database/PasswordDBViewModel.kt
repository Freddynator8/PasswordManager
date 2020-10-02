package com.example.passwordmanager.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PasswordDBViewModel(application: Application): AndroidViewModel(application) {
    val readAllPasswords: LiveData<List<PasswordDBDefinition>>
    private val repository: PasswordDBRepository

    init{
        val passwordDao = PasswordDBDatabase.getPasswordDB(application).passwordDBDao()
        repository = PasswordDBRepository(passwordDao)
        readAllPasswords = repository.readAllPasswords
    }

    fun addPassword(item: PasswordDBDefinition){
        viewModelScope.launch(Dispatchers.IO){
            repository.addPassword(item)
        }
    }

    fun updatePassword(item: PasswordDBDefinition){
        viewModelScope.launch(Dispatchers.IO){
            repository.updatePassword(item)
        }
    }

    fun deletePassword(item: PasswordDBDefinition){
        viewModelScope.launch(Dispatchers.IO){
            repository.deletePassword(item)
        }
    }

    fun deleteAllPassword(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllPasswords()
        }
    }
}