package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(private var name: String, private var company: String, var size: Double?, private var description: String,
                val images: List<String> = mutableListOf()) : Parcelable, BaseObservable() {



    @Bindable
    fun getName() : String {
        return name
    }
    fun setName(value : String) {
        name = value
    }

    @Bindable
    fun getCompany() : String {
        return company
    }
    fun setCompany(value : String) {
        company = value
    }

    @Bindable
    fun getDescription() : String {
        return description
    }
    fun setDescription(value : String) {
        description = value
    }

    @Bindable
    fun getSize() : String {
        return size.toString()
    }
    fun setSize(value : String) {
        if (value.isNullOrEmpty()){
            size = 0.0
        }else{
            size = value.toDouble()
        }

    }
}
