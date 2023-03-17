package com.geekymusketeers.trackit.auth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.geekymusketeers.trackit.R
import com.geekymusketeers.trackit.databinding.FragmentGenderBinding
import com.geekymusketeers.trackit.databinding.FragmentNameBinding


class NameFragment : Fragment() {

    private var _binding: FragmentNameBinding? = null
    private val binding get() = _binding!!
    private val args: NameFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        handleOperations()
        return binding.root
    }

    private fun handleOperations() {
        binding.continueName.setOnClickListener {
            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            if (firstName.isEmpty() && lastName.isEmpty()) {
                binding.apply {
                    allDetailsHelperTV.text = "Please Enter the Details."
                    allDetailsHelperTV.visibility = View.VISIBLE
                }
                return@setOnClickListener
            }else if (firstName.isEmpty()){
                binding.apply {
                    firstNameHelperTV.text = "Please Enter the First Name."
                    firstNameHelperTV.visibility = View.VISIBLE
                }
            }else if (lastName.isEmpty()){
                binding.apply {
                    lastNameHelperTV.text = "Please Enter the Last Name."
                    lastNameHelperTV.visibility = View.VISIBLE
                }
            }
            // Passing the value taken from Name Fragment to UserDetails Fragment
            val action = NameFragmentDirections.actionNameFragmentToUserDetailsFragment(firstName, lastName, args.gender)
            findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}