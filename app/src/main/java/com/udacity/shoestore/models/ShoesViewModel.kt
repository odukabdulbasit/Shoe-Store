package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class SaveState {
    SAVE,
    Cancel
}

class ShoesViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private var _saveState = MutableLiveData<SaveState>()
    val saveState : LiveData<SaveState>
        get() = _saveState


    init {
        _shoeList.value = mutableListOf()
       addToList()
        _saveState.value = SaveState.Cancel
    }



    fun createNewShoes(name: String, company: String, size: String, description: String){

        var sizeDouble : Double = 0.0
        try {
            sizeDouble = size.toDouble()
        } catch (e: NumberFormatException) {
            e.stackTrace
        }

        addNewShoe(name, company, sizeDouble, description)

        _saveState.value = SaveState.SAVE
    }


    fun addNewShoe(name: String, company: String, size: Double, description: String) {

        _shoeList.value?.add(Shoe(name, company, size, description))
    }

    private fun addToList() {

        shoeList.value?.add(Shoe("Cerok", "Mardin",47.0, "Cerok is a type of shoe that wear on town. \n Especialy it is using in Mardin(city in Turkey) a lot."))
    }

    fun onEventSaveComplete() {

        _saveState.value = SaveState.Cancel
    }
}