package com.example.shoestore.screens.welcome

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.ShoeViewModel
import com.example.shoestore.databinding.LoginFragmentBinding
import com.example.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.welcome_fragment,
            container,
            false)

        binding.shoeViewModel = viewModel

        setHasOptionsMenu(true)

        viewModel.eventGoToInstruction.observe(viewLifecycleOwner, Observer { goToInstructions ->
            goToInstructions?.let {
                if (it){
                    findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
                    viewModel.onEventGoToInstructionsCompleted()
                }
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}