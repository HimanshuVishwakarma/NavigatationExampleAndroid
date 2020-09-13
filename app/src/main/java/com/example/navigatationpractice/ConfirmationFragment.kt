package com.example.navigatationpractice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_confirmation.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ConfirmationFragment : Fragment() {
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var name: String? = null
        var amount: Int? = null
        arguments?.let {
            name = it.getString("name")
            amount = it.getInt("value")
        }
        val message = "Rs. ${amount.toString()} is sent to $name"
        Log.d("Himanshu", "$name $amount $message")

        view.textView6?.let {
            it.text = message
        }
        navController = Navigation.findNavController(view)
        view.button.setOnClickListener {
            navController.navigate(R.id.action_confirmationFragment_to_home2)
        }
    }

}