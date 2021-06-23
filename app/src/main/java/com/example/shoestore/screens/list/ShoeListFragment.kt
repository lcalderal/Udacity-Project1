package com.example.shoestore.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var viewModelFactory: ShoeListViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
                    R.layout.shoe_list_fragment,
                    container,
                    false)

        val shoeListFragmentArgs by navArgs<ShoeListFragmentArgs>()

        viewModelFactory = ShoeListViewModelFactory(shoeListFragmentArgs.shoeName, shoeListFragmentArgs.company, shoeListFragmentArgs.size)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel

        binding.setLifecycleOwner(this)

        Toast.makeText(context, "Valor passado: " + viewModel.shoeName.value.toString(), Toast.LENGTH_SHORT).show()
//        Toast.makeText(context, "Valor da lista: " + viewModel.shoeList.value?.get(0).toString(), Toast.LENGTH_SHORT).show()

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

//    fun createTv(shoeName: String){
//        val myLayout = LinearLayout(context).findViewById<LinearLayout>(R.id.linearLayout)
//        val tv = TextView(context)
////        val linearLayout = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//
//        tv.text = shoeName
//
//        myLayout.addView(tv)
//    }

}
