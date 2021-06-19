package com.example.shoestore.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var viewModelShoe: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
                    R.layout.shoe_list_fragment,
                    container,
                    false)

        viewModelShoe = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}