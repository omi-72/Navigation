package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

import com.example.navigation.databinding.FragmentChooseReceiverBinding

class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver){

    private lateinit var binding : FragmentChooseReceiverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseReceiverBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {

            val receiverName = binding.etReceiverName.text.toString()

            val action = ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(receiverName)
            findNavController().navigate(action)
        }

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}