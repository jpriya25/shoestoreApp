package com.jp.shoestoreapp.welcome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jp.shoestoreapp.R
import com.jp.shoestoreapp.databinding.WelcomeFragmentBinding
import com.jp.shoestoreapp.welcome.WelcomeFragmentDirections.Companion.actionWelcomeFragmentToInstructionFragment
import kotlinx.android.synthetic.main.welcome_fragment.*

class WelcomeFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeFragment()
    }

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding = WelcomeFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.viewModel=viewModel;

        viewModel.navigateStoreList.observe(viewLifecycleOwner){actionNavigate ->
            if (actionNavigate) {
              //  Navigation.createNavigateOnClickListener(R.id.actionWelcomeFragmentToInstructionFragment())

                     findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())

            }

        }
        return binding.root;
    }

}