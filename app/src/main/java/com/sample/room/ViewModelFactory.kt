package com.sample.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.room.data.UserDatabase
import com.sample.room.data.UserRepository
import com.sample.room.viewmodel.UserViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(_repository = UserRepository(UserDatabase.getDatabase().userDao())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}