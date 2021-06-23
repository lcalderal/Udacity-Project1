package com.example.shoestore.screens.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel(finalName: String, finalCompany: String, finalSize: String) : ViewModel() {

    private var shoeListAdd = ArrayList<String>()

    private var _shoeList = MutableLiveData<List<String>>()
    val shoeList : LiveData<List<String>>
        get() = _shoeList

    private val _shoeName = MutableLiveData<String>()
    val shoeName : LiveData<String>
        get() = _shoeName

    private val _company = MutableLiveData<String>()
    val company : LiveData<String>
        get() = _company

    private val _size = MutableLiveData<String>()
    val size : LiveData<String>
        get() = _size


    init {
        _shoeList.value = listOf(finalName, finalCompany, finalSize)
        _shoeName.value = finalName
        _company.value = finalCompany
        _size.value = finalSize

    }

//
//    fun addShoe(shoe: String, company: String, size: String){
//        _shoeList.value = listOf()
//    }

}


