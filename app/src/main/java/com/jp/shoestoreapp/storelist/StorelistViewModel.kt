package com.jp.shoestoreapp.storelist

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jp.shoestoreapp.Shoe

class StorelistViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var isNavigateDetailPage = MutableLiveData<Boolean>();
    var isNavigateListPage = MutableLiveData<Boolean>();
    private val shoesList = mutableListOf<Shoe>()

    private val _shoesListLiveData = MutableLiveData<List<Shoe>>()
    val shoesListLiveData: LiveData<List<Shoe>>
        get() = _shoesListLiveData


    private val _shoeLiveData = MutableLiveData<Shoe>()
    val shoeLiveData: LiveData<Shoe>
        get() = _shoeLiveData
    init {
        isNavigateDetailPage.value = false
        isNavigateListPage.value = false
        _shoeLiveData.value = Shoe("", "0.0", "", "")

    }

    fun navigateToStoreDetailsPage(){
        isNavigateDetailPage.value = true

    }
    fun navigateToStorListPage(){
        isNavigateListPage.value = true
        isNavigateDetailPage.value = false
        isNavigateListPage.value = false

    }

    fun  reSetValue(){
        isNavigateListPage.value = false
        isNavigateDetailPage.value = false


    }



    fun addShoe(shoe: Shoe) {
        shoesList.add(shoe)
        _shoesListLiveData.value = shoesList
        isNavigateListPage.value = true

    }


    override fun onCleared() {
        super.onCleared()
        isNavigateListPage.value = false
        isNavigateDetailPage.value = false


    }
}