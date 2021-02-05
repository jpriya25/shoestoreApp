package com.jp.shoestoreapp.storelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.jp.shoestoreapp.R
import com.jp.shoestoreapp.databinding.FragmentStoreDetailsBinding
import com.jp.shoestoreapp.databinding.StorelistFragmentBinding

class StoreDetailsFragment : Fragment() {
    private val sharedViewModel: StorelistViewModel by activityViewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentStoreDetailsBinding.inflate(inflater)
       var vm= ViewModelProvider(this).get(sharedViewModel::class.java)
        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = this



     binding.save.setOnClickListener {


         sharedViewModel.addShoe(sharedViewModel.shoeLiveData.value!!)
     }
        sharedViewModel.isNavigateListPage.observe(viewLifecycleOwner){actionNavigate ->
            if(actionNavigate){
                findNavController().navigate(R.id.action_storeDetailsFragment_to_storelistFragment);
            }
        }


        return binding.root;
    }

}