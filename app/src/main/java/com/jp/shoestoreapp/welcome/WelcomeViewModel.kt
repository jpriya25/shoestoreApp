package com.jp.shoestoreapp.welcome

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    var  navigateStoreList= MutableLiveData<Boolean>();

  init {
      navigateStoreList.value=false;
  }

  fun navigateToList(){
      navigateStoreList.value=true;


  }


}