package com.jp.shoestoreapp.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var navigateToOnBoard = MutableLiveData<Boolean>();

    init {
        navigateToOnBoard.value = false
    }

    fun navigateToWelcome() {
        navigateToOnBoard.value = true

    }

}