package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.SaveState
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel

class ShoeDetailFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailBinding
    private val shoeViewModel : ShoesViewModel by activityViewModels()

    private val shoeData = Shoe("", "", 0.0, "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )


        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this
        binding.shoeData = shoeData


        binding.buttonCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        shoeViewModel.saveState.observe(this as LifecycleOwner, Observer {statte->
            if (statte == SaveState.SAVE){
                view?.findNavController()?.navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
                shoeViewModel.onEventSaveComplete()
            }
        })

        return binding.root
    }
}
