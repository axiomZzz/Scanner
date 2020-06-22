package com.github.axiomzzz.jsoupparsinghtml

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class ScannerFragment : Fragment(), ZXingScannerView.ResultHandler {

    private val _viewModel:RootViewModel by sharedViewModel ()

    private val MY_PERMISSIONS_REQUEST_CAMERA=0


    private  val mScannerView : ZXingScannerView by lazy{
        ZXingScannerView(this.context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mScannerView
    }

    override fun onResume() {
        super.onResume()
        mScannerView.setResultHandler(this) // Register ourselves as a handler for scan results.
        mScannerView.startCamera()

        if (activity?.applicationContext?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.CAMERA
                )
            }
            != PackageManager.PERMISSION_GRANTED
        ) {
            activity?.parent?.let {
                ActivityCompat.requestPermissions(
                    it, arrayOf(Manifest.permission.CAMERA),
                    MY_PERMISSIONS_REQUEST_CAMERA
                )
            }
        }// Start camera on resume
    }

    override fun onPause() {
        super.onPause()
        mScannerView.stopCamera() // Stop camera on pause
    }

    override fun handleResult(rawResult: Result?) {

        _viewModel.test=1

        Toast.makeText(this.context,rawResult?.text,Toast.LENGTH_SHORT).show()

        _viewModel._getl(rawResult.toString())

        findNavController().navigate(R.id.action_scannerFragment_to_rootFragment)

    }




}
