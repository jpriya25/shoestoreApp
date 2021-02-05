package com.jp.shoestoreapp.instruction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {
    var isInstruction = MutableLiveData<Boolean>();

    init {
        isInstruction.value = false
    }
   fun navigateToStoreList(){
     isInstruction.value = true

 }
}