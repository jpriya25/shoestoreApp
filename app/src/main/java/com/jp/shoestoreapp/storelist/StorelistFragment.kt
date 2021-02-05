package com.jp.shoestoreapp.storelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.jp.shoestoreapp.R
import com.jp.shoestoreapp.Shoe
import com.jp.shoestoreapp.databinding.ShoelistingBinding
import com.jp.shoestoreapp.databinding.StorelistFragmentBinding
import com.jp.shoestoreapp.databinding.WelcomeFragmentBinding

class StorelistFragment : Fragment() {
    private val sharedViewModel: StorelistViewModel by activityViewModels()

    companion object {
        fun newInstance() = StorelistFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: StorelistFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.storelist_fragment, container, false)

        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = this

        sharedViewModel.isNavigateDetailPage.observe(viewLifecycleOwner) { actionNavigate ->
            if (actionNavigate) {

                findNavController().navigate(StorelistFragmentDirections.actionStorelistFragmentToStoreDetailsFragment())
                sharedViewModel.reSetValue();

            }
        }





        sharedViewModel.shoes.observe(viewLifecycleOwner, Observer { list ->


            sharedViewModel.reSetValue();
            for (shoe: Shoe in list) {

                val shoeLayoutBinding: ShoelistingBinding = DataBindingUtil.inflate(
                        layoutInflater, R.layout.shoelisting, null, false)
                shoeLayoutBinding.shoe = shoe
                binding.shoesList.addView(shoeLayoutBinding.root)

            }

        })




        setHasOptionsMenu(true)
        return binding.root;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.LoginFragment) {
            Logout()
        }
        return super.onOptionsItemSelected(item)
    }


    fun Logout() {
        findNavController().navigate(R.id.action_storelistFragment_to_login)

    }
}