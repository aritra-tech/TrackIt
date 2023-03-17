package com.geekymusketeers.trackit.auth.fragments

import android.R
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geekymusketeers.trackit.databinding.FragmentGenderBinding


class GenderFragment : Fragment() {

    private var _binding: FragmentGenderBinding? = null
    private val binding get() = _binding!!
    var selectedGender : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGenderBinding.inflate(inflater, container, false)
        selectOption()
        handleOperation()
        return binding.root
    }

    private fun handleOperation() {
        binding.continueGender.setOnClickListener {
            if (selectedGender.isEmpty()) {
                Toast.makeText(requireContext(), "Please select gender", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val actions = GenderFragmentDirections.actionGenderFragmentToNameFragment(selectedGender)
            findNavController().navigate(actions)
        }
    }

    private fun selectOption() {
        binding.maleLayout.setOnClickListener {
            binding.maleLayout.backgroundTintList = ColorStateList.valueOf(ResourcesCompat.getColor(resources,R.color.holo_blue_light, null))
            binding.femaleLayout.backgroundTintList = ColorStateList.valueOf(ResourcesCompat.getColor(resources,R.color.white, null))
            selectedGender = "male"
        }
        binding.femaleLayout.setOnClickListener {
            binding.femaleLayout.backgroundTintList = ColorStateList.valueOf(ResourcesCompat.getColor(resources,R.color.holo_blue_light, null))
            binding.maleLayout.backgroundTintList = ColorStateList.valueOf(ResourcesCompat.getColor(resources,R.color.white, null))
            selectedGender = "female"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}