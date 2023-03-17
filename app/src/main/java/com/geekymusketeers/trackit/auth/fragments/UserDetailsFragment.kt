package com.geekymusketeers.trackit.auth.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.geekymusketeers.trackit.MainActivity
import com.geekymusketeers.trackit.model.User
import com.geekymusketeers.trackit.databinding.FragmentUserdetailsBinding
import com.geekymusketeers.trackit.viewmodel.FirebaseViewModel
import com.google.firebase.auth.FirebaseAuth

class UserDetailsFragment : Fragment() {

    private var _binding: FragmentUserdetailsBinding? = null
    private val binding get() = _binding!!
    lateinit var  userViewModel : FirebaseViewModel
    private val args: UserDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUserdetailsBinding.inflate(inflater, container, false)
        userViewModel = ViewModelProvider(requireActivity())[FirebaseViewModel::class.java]
        initObservers()
        handleOperations()
        return binding.root
    }

    private fun initObservers() {
        userViewModel.run {
            saveUserStatusLiveData.observe(viewLifecycleOwner) {
                if (it) {
                    startActivity(Intent(requireActivity(), MainActivity::class.java)).also {
                        requireActivity().finish()
                    }
                }
            }
            errorLiveData.observe(viewLifecycleOwner) {
                Log.d("Error Value",it)
            }
        }

    }

    private fun handleOperations() {
        binding.saveDetails.setOnClickListener {
            val age = binding.age.text.toString()
            val height = binding.age.text.toString()
            val weight = binding.age.text.toString()
            if (age.isEmpty() and height.isEmpty() and weight.isEmpty()) {
                binding.apply {
                    allDetailsHelperTV.text = "Please Enter the Details."
                    allDetailsHelperTV.visibility = View.VISIBLE
                }
                return@setOnClickListener
            }else if (age.isEmpty()){
                binding.apply {
                    ageHelperTV.text = "Please Enter the Age."
                    ageHelperTV.visibility = View.VISIBLE
                }
            }else if (height.isEmpty()){
                binding.apply {
                    heightHelperTV.text = "Please Enter the Height."
                    heightHelperTV.visibility = View.VISIBLE
                }
            }else if (weight.isEmpty()){
                binding.apply {
                    weightHelperTV.text = "Please Enter the Weight."
                    weightHelperTV.visibility = View.VISIBLE
                }
            }
            // Saving the data to Firebase Realtime DB
            val user = User (
                FirebaseAuth.getInstance().currentUser!!.uid,
                args.gender,
                args.firstname + " " + args.lastname,
                age,
                height,
                weight
            )
            userViewModel.saveUser(user)
        }

    }

}