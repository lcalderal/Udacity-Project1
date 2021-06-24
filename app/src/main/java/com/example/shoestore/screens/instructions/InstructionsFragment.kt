package com.example.shoestore.screens.instructions

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.ShoeViewModel
import com.example.shoestore.databinding.InstructionsFragmentBinding
import com.example.shoestore.screens.welcome.WelcomeFragmentDirections

class InstructionsFragment : Fragment() {

    private lateinit var binding: InstructionsFragmentBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.instructions_fragment,
            container,
            false)

        binding.shoeViewModel = viewModel

        viewModel.eventGoToShoeList.observe(viewLifecycleOwner, Observer { goToShoeList ->
            goToShoeList?.let {
                if (it){
                    findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
                    viewModel.onEventGoToShoeListCompleted()
                }
            }
        })



        // Inflate the layout for this fragment
        return binding.root
    }

}