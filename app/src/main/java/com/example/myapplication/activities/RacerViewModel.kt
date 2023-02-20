package com.example.myapplication.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RacerViewModel : ViewModel() {
    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> = _firstName

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    private val _dateOfBirth = MutableLiveData<String>()
    val dateOfBirth: LiveData<String> = _dateOfBirth

    private val _vehicleBrand = MutableLiveData<String>()
    val vehicleBrand: LiveData<String> = _vehicleBrand

    private val _vehicleModel = MutableLiveData<String>()
    val vehicleModel: LiveData<String> = _vehicleModel

    private val _trackName = MutableLiveData<String>()
    val trackName: LiveData<String> = _trackName

    private val _recordTime = MutableLiveData<String>()
    val recordTime: LiveData<String> = _recordTime

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

    fun setDateOfBirth(dateOfBirth: String) {
        _dateOfBirth.value = dateOfBirth
    }

    fun setVehicleBrandName(vehicleBrand: String) {
        _vehicleBrand.value = vehicleBrand
    }

    fun setVehicleModel(vehicleModel: String) {
        _vehicleModel.value = vehicleModel
    }

    fun setTrackName(trackName: String) {
        _trackName.value = trackName
    }

    fun setRecordTime(recordTime: String) {
        _recordTime.value = recordTime
    }
    fun setId(id: Int) {
        _id.value = id
    }
}