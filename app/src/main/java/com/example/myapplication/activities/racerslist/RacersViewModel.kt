package com.example.myapplication.activities.racerslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.RestApi.Racer

class RacersViewModel(val racer: Racer) : ViewModel() {
    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> = _firstName

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    init {
        // Set initial values for the order
        reset()
    }

    fun reset() {
        _firstName.value = "Adam"
        _lastName.value = "Małysz"
    }
}
