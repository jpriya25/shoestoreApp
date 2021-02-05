package com.jp.shoestoreapp.instruction

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.jp.shoestoreapp.R
import com.jp.shoestoreapp.databinding.InstructionFragmentBinding
import com.jp.shoestoreapp.databinding.WelcomeFragmentBinding

class InstructionFragment : Fragment() {
    companion object {
        fun newInstance() = InstructionFragment()
    }
    private lateinit var viewModel: InstructionViewModel
    lateinit var binding: InstructionFragmentBinding;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.instruction_fragment, container, false)


        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.isInstruction.observe(viewLifecycleOwner) { navigate ->
            if (navigate) {
                findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToStorelistFragment())
            }
        }
        return binding.root;
    }
}