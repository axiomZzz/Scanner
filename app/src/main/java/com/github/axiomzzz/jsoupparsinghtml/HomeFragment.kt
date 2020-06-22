package com.github.axiomzzz.jsoupparsinghtml


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : Fragment(R.layout.home_fragment) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {

            findNavController().navigate(
                R.id.action_homeFragment_to_scannerFragment
            )
        }
    }

}
