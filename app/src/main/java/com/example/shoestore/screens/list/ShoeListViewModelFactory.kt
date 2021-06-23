package com.example.shoestore.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ShoeListViewModelFactory(private val finalName: String, private val finalCompany: String, private val finalSize: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListViewModel::class.java)) {
            return ShoeListViewModel(finalName, finalCompany, finalSize) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}