package com.github.axiomzzz.jsoupparsinghtml


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.root_fragment.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class RootFragment : Fragment(R.layout.root_fragment) {

    private val _viewModel:RootViewModel by sharedViewModel ()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView2.text=_viewModel.test.toString()


        _viewModel.data.observe(viewLifecycleOwner, Observer {
            textView2.text=it.title()
        })


        _viewModel.imageUrl.observe(viewLifecycleOwner, Observer {
//            imageView.load(it)
//            Log.i("AAAA", "Bye $it")
            Glide.with(this)
                .load(it)
                .into(imageView)
        })





    }
}
