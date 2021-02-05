package com.jp.shoestoreapp.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jp.shoestoreapp.R
import com.jp.shoestoreapp.databinding.ActivityMainBinding
import com.jp.shoestoreapp.databinding.LoginScreenBinding
import com.jp.shoestoreapp.databinding.StorelistFragmentBinding

class Login : Fragment() {
    companion object {
        fun newInstance() = Login()
    }

    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      //  binding = LoginScreenBinding.inflate(inflater)

        var binding: LoginScreenBinding = DataBindingUtil.inflate(
                inflater, R.layout.login_screen, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        //make binding observe LiveData
        binding.lifecycleOwner = this
        viewModel.navigateToOnBoard.observe(viewLifecycleOwner) { actionNavigate ->
            if (actionNavigate) {

               findNavController().navigate(LoginDirections.actionLoginToWelcomeFragment())
            }
        }
        return binding.root
    }
}