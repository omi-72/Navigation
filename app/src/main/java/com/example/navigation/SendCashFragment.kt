package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.databinding.FragmentSendCashBinding

class SendCashFragment : Fragment(R.layout.fragment_send_cash){

    private lateinit var binding : FragmentSendCashBinding
    private val args : SendCashFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSendCashBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val receiverName =  args.receiverName


        binding.tvReceiverName.text = "Send cash to $receiverName"

        binding.btnSend.setOnClickListener {

            if (binding.etAmount.text.toString().isEmpty()) {

                Toast.makeText(requireContext(), "Enter some amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = binding.etAmount.text.toString().toLong()
            val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(receiverName, amount)
            findNavController().navigate(action)
        }

        binding.btnDone.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, true)
        }

    }
}