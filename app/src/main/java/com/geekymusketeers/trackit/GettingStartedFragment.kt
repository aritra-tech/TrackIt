package com.geekymusketeers.trackit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geekymusketeers.trackit.databinding.FragmentGettingStartedBinding

class GettingStartedFragment : Fragment() {

    private var _binding: FragmentGettingStartedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGettingStartedBinding.inflate(inflater, container, false)
        goToSignIn()
        return binding.root
    }

    private fun goToSignIn() {
        binding.signInBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gettingStartedFragment_to_signInFragment)
        }
    }
}