package com.example.shoestore.screens.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.ShoeViewModel
import com.example.shoestore.databinding.ItemShoeBinding
import com.example.shoestore.databinding.ShoeListFragmentBinding
import com.example.shoestore.model.Shoe

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
                    R.layout.shoe_list_fragment,
                    container,
                    false)

        setHasOptionsMenu(true)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList?.let {
                showShoes(it)
            }
        })

        binding.floatingActionButton.setOnClickListener{
            it.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun showShoes (shoes: List<Shoe>) {
        shoes.forEach { showShoeInfo(it) }
    }

    private fun showShoeInfo(shoe: Shoe){
        val itemShoeBinding: ItemShoeBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_shoe, null, false)

        itemShoeBinding.txtFinalName.text = getString(R.string.shoe_name) + shoe.shoeName
        itemShoeBinding.txtFinalSize.text = getString(R.string.shoe_size) + shoe.size
        itemShoeBinding.txtFinalCompany.text = getString(R.string.company) + shoe.company

        binding.linearLayout.addView(itemShoeBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}
