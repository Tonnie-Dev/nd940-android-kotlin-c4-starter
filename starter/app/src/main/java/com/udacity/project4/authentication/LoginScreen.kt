package com.udacity.project4.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.registerForActivityResult
import androidx.fragment.app.viewModels
import com.firebase.ui.auth.IdpResponse
import com.udacity.project4.R
import timber.log.Timber


class LoginScreen : Fragment() {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.authStateLiveData.observe(viewLifecycleOwner){
            
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val authResult = registerForActivityResult(AuthResultContract()) {

            handleResponse(it)
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_screen, container, false)
    }

    private fun handleResponse(idpResponse: IdpResponse?) {


        if (idpResponse == null || idpResponse.error != null) {

            Timber.i("Login Unsuccessful")
        } else {
            Timber.i("Login Successful")
        }
    }

}