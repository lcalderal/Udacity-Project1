package com.example.shoestore.screens.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel(finalName: String, finalCompany: String, finalSize: String) : ViewModel() {

//    private var temp: MutableList<String>

    private var _shoeList = MutableLiveData<MutableList<String>>()
    val shoeList : LiveData<MutableList<String>>
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

        addShoe(finalName, finalCompany, finalSize)
//        _shoeName.value = finalName
//        _company.value = finalCompany
//        _size.value = finalSize
    }


    fun addShoe(name: String, company: String, size: String){
        var temp = mutableListOf<String>()

        Log.i("-----------", "Valor da showlist: " + _shoeList.value.toString())

        if (!(name == "" && company == "" && size == "")) {
            if (_shoeList.value.isNullOrEmpty()){
                Log.i("------------", "ENTROU NO IF")
                temp.add(name)
                temp.add(company)
                temp.add(size)
                _shoeList.value = temp
            }
            else {
                temp = _shoeList.value!!
                temp.add(name)
                temp.add(company)
                temp.add(size)

                _shoeList.value = temp
            }
        }
    }

}


