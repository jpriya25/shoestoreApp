package com.jp.shoestoreapp.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.jp.shoestoreapp.R
import com.jp.shoestoreapp.databinding.ActivityMainBinding
import com.jp.shoestoreapp.databinding.LoginScreenBinding

class Login : Fragment() {
    companion object {
        fun newInstance() = Login()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginScreenBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = LoginScreenBinding.inflate(inflater)
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