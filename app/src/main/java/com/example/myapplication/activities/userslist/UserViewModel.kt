package com.example.myapplication.activities.userslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> = _firstName

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    private val _description = MutableLiveData<String>()
    val description: LiveData<String> = _description

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _id = MutableLiveData<Int>()
    val id: LiveData<Int> = _id

    init {
        // Set initial values for the order
        reset()
    }

    fun setFirstName(firstName: String){
        _firstName.value = firstName
    }

    fun reset() {
        _firstName.value = "Adam"
        _lastName.value = "Małysz"
    }

    fun setLastName(lastName: String) {
        _lastName.value = lastName
    }

    fun setDescritpion(description: String) {
        _description.value = description
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setId(id: Int) {
        _id.value = id
    }
}