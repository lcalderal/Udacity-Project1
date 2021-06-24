package com.example.shoestore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shoestore.R
import com.example.shoestore.databinding.DetailFragmentBinding
import com.example.shoestore.screens.list.ShoeListFragmentArgs
import com.example.shoestore.screens.list.ShoeListViewModel
import com.example.shoestore.screens.list.ShoeListViewModelFactory

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
            //TODO: COLOCAR A FUNÇÃO DE ADICIONAR UM ITEM NA LISTA4

            val currentName = binding.etShoeName.text.toString()
            val currentCompany = binding.etCompany.text.toString()
            val currentSize = binding.etShoeSize.text.toString()

            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment(currentName, currentCompany, currentSize))
        }




//        binding.btnCancel.setOnClickListener {
//            val currentName = viewModel.shoeName.value
//            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment(currentName))
//        }


        // Inflate the layout for this fragment
        return binding.root
    }
}

