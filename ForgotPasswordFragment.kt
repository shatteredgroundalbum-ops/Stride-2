package com.stride.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.stride.app.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : BaseFragment() {

    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateOrientation()
        setupClickListeners()
    }

    override fun onOrientationChanged() {
        updateOrientation()
    }

    private fun updateOrientation() {
        updateOrientation(binding.portraitLayout, binding.landscapeLayout, binding.bgPortrait, binding.bgLandscape)
    }

    private fun setupClickListeners() {
        binding.btnSendP.setOnClickListener { sendReset() }
        binding.btnBackLoginP.setOnClickListener { goBack() }
        binding.btnSendL.setOnClickListener { sendReset() }
        binding.btnBackLoginL.setOnClickListener { goBack() }
    }

    private fun sendReset() {
        val isPortrait = binding.portraitLayout.visibility == View.VISIBLE
        val email = if (isPortrait) binding.emailInputP.text.toString().trim() else binding.emailInputL.text.toString().trim()

        if (email.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter your email address", Toast.LENGTH_SHORT).show()
            return
        }

        // TODO: Add real password reset here
        Toast.makeText(requireContext(), "Reset link sent to $email", Toast.LENGTH_LONG).show()
        goBack()
    }

    private fun goBack() {
        findNavController().navigate(R.id.action_forgot_to_login)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
