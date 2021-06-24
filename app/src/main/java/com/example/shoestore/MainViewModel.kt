package com.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.Shoe

class MainViewModel : ViewModel() {

    var currentShoe: Shoe? = null

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _eventClose = MutableLiveData<Boolean>()
    val eventClose: LiveData<Boolean>
        get() = _eventClose

    private val _eventGoToWelcome = MutableLiveData<Boolean>()
    val eventGoToWelcome: LiveData<Boolean>
        get() = _eventGoToWelcome

    private val _eventGoToInstruction = MutableLiveData<Boolean>()
    val eventGoToInstruction: LiveData<Boolean>
        get() = _eventGoToInstruction

    private val _eventGoToShoeList = MutableLiveData<Boolean>()
    val eventGoToShoeList: LiveData<Boolean>
        get() = _eventGoToShoeList

    fun close() {
        _eventClose.value = true
    }

    fun onEventCloseCompleted() {
        _eventClose.value = null
    }

    fun goToWelcomeScreen() {
        _eventGoToWelcome.value = true
    }

    fun onEventGoToWelcomeScreenCompleted() {
        _eventGoToWelcome.value = null
    }

    fun goToInstructionScreen() {
        _eventGoToInstruction.value = true
    }

    fun onEventGoToInstructionScreenCompleted() {
        _eventGoToInstruction.value = null
    }

    fun goToShoeListScreen() {
        _eventGoToShoeList.value = true
    }

    fun onEventGoToShoeListScreenCompleted() {
        _eventGoToShoeList.value = null
    }

    fun createNewShoe() {
        currentShoe = Shoe("", 0, "")
    }

    init {
        _shoeList.value = addExampleShoes()
    }

    private fun addExampleShoes() : List<Shoe> {
        val temp = mutableListOf<Shoe>()

        temp.add(Shoe("Nike Shox", 41, "Nike"))
        temp.add(Shoe("Puma Disk", 35, "Puma"))
        temp.add(Shoe("Nike Mercurial", 39, "Nike"))

        return temp
    }

    fun onSave() {
        val temp = mutableListOf<Shoe>()
    }
}