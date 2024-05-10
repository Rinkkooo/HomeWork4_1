package com.example.homework4_1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework4_1.R
import com.example.homework4_1.databinding.FragmentMainBinding
import com.example.homework4_1.ui.model.User

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListen()
    }

    private fun setupListen() {
        binding.btnSend.setOnClickListener{
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString().toInt()
            val user = User(name, email, password)

            val action = MainFragmentDirections.actionMainFragmentToFirstFragment(user)
            findNavController().navigate(action)
        }
    }
}