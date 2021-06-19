package com.example.shoestore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
                    R.layout.detail_fragment,
                    container,
                    false)

        binding.btnSave.setOnClickListener {
            //TODO: COLOCAR A FUNÇÃO DE ADICIONAR UM ITEM NA LISTA
            
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment())
        }

        binding.btnCancel.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}