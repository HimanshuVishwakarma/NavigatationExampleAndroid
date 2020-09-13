package com.example.navigatationpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_name.view.*

class NameFragment : Fragment() {

    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.button3.setOnClickListener {
            val name = getName(view)
            if (name != null) {
                val bundle = Bundle()
                bundle.putString("name", name)
                navController.navigate(R.id.action_nameFragment_to_amoutFragment, bundle)
            } else {
                Toast.makeText(it.context, "Enter name", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getName(view: View): String? {
        val name = view.editTextTextPersonName.text.toString()
        if (name == "")
            return null
        else
            return name
    }
}