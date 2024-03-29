package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentHomeBinding
import com.example.navigation.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings){

    private lateinit var binding : FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etDefaultAmount.setText(SampleData.defaultAmount.value.toString())

        binding.btnSaveDefaultAmount.setOnClickListener {
            val defaultAmount = binding.etDefaultAmount.text.toString().toLong()
            SampleData.defaultAmount.value = defaultAmount
        }

        binding.btnAboutApp.setOnClickListener {
            val action = MainNavGraphDirections.actionGlobalAboutAppFragment()
            findNavController().navigate(action)
        }


    }
}