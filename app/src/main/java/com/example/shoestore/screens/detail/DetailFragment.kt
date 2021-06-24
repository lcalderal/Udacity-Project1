package com.example.shoestore.screens.detail

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
import com.example.shoestore.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
                    R.layout.detail_fragment,
                    container,
                    false)

        binding.shoeViewModel = viewModel

        viewModel.createNewShoe()

        viewModel.eventClose.observe(viewLifecycleOwner, Observer { onClose ->
            onClose?.let {
                if (it) {
                    findNavController().navigateUp()
                    viewModel.onEventCloseCompleted()
                }
            }

        })

        // Inflate the layout for this fragment
        return binding.root
    }
}

