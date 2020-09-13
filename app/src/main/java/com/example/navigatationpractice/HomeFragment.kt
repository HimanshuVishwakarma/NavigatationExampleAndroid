package com.example.navigatationpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        handleClickListeners(view)
    }

    private fun handleClickListeners(view: View) {
        view.checkProfileButton.setOnClickListener {
            navController.navigate(R.id.action_home2_to_profileFragment)
        }

        view.sendMoneyButton.setOnClickListener {
            navController.navigate(R.id.action_home2_to_nameFragment)
        }
    }
}