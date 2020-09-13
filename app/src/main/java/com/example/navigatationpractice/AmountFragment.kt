package com.example.navigatationpractice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_amount.view.*
import kotlinx.android.synthetic.main.fragment_name.view.*

class AmoutFragment : Fragment() {
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("name")
        val text: String = "Enter amount you want to send to $name"
        view.textView3.text = text

        navController = Navigation.findNavController(view)
        view.button4.setOnClickListener {
            val amount = getAmount(view)
            if (amount != null) {
                val bundle = Bundle()
                bundle.putInt("value", amount.toInt())
                bundle.putString("name", name)
                navController.navigate(R.id.action_amoutFragment_to_confirmationFragment, bundle)
            } else {
                Toast.makeText(it.context, "Enter amount to send.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getAmount(view: View): String? {
        val amount: String = view.editTextTextPersonName2.text.toString()
        return if (amount == "")
            null
        else
            amount
    }
}