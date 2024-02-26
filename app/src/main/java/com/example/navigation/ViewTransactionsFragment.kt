package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.navigation.databinding.FragmentViewTransactionsBinding

class ViewTransactionsFragment : Fragment(R.layout.fragment_view_transactions)
{
    private lateinit var binding : FragmentViewTransactionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewTransactionsBinding.inflate(inflater)
        return binding.root

    }

}