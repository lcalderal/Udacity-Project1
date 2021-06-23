package com.example.shoestore.screens.instructions

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.InstructionsFragmentBinding
import com.example.shoestore.screens.welcome.WelcomeFragmentDirections

class InstructionsFragment : Fragment() {

    private lateinit var binding: InstructionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.instructions_fragment,
            container,
            false)


        binding.btnShoeList.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment("", "", ""))
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}