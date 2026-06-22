package com.stride.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.stride.app.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
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
        // Portrait buttons
        binding.btnLoginP.setOnClickListener { attemptLogin() }
        binding.forgotPasswordP.setOnClickListener { goToForgot() }
        binding.goToCreateP.setOnClickListener { goToCreate() }
        binding.btnGoogleP.setOnClickListener { Toast.makeText(requireContext(), "Google Sign-In coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnAppleP.setOnClickListener { Toast.makeText(requireContext(), "Apple Sign-In coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnFacebookP.setOnClickListener { Toast.makeText(requireContext(), "Facebook Sign-In coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnInstagramP.setOnClickListener { Toast.makeText(requireContext(), "Instagram Sign-In coming soon", Toast.LENGTH_SHORT).show() }

        // Landscape buttons
        binding.btnLoginL.setOnClickListener { attemptLogin() }
        binding.forgotPasswordL.setOnClickListener { goToForgot() }
        binding.goToCreateL.setOnClickListener { goToCreate() }
        binding.btnGoogleL.setOnClickListener { Toast.makeText(requireContext(), "Google Sign-In coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnAppleL.setOnClickListener { Toast.makeText(requireContext(), "Apple Sign-In coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnFacebookL.setOnClickListener { Toast.makeText(requireContext(), "Facebook Sign-In coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnInstagramL.setOnClickListener { Toast.makeText(requireContext(), "Instagram Sign-In coming soon", Toast.LENGTH_SHORT).show() }
    }

    private fun attemptLogin() {
        // Get input from whichever layout is visible
        val email = if (binding.portraitLayout.visibility == View.VISIBLE)
            binding.emailInputP.text.toString().trim()
        else
            binding.emailInputL.text.toString().trim()

        val password = if (binding.portraitLayout.visibility == View.VISIBLE)
            binding.passwordInputP.text.toString()
        else
            binding.passwordInputL.text.toString()

        if (email.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter your email", Toast.LENGTH_SHORT).show()
            return
        }
        if (password.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter your password", Toast.LENGTH_SHORT).show()
            return
        }

        // TODO: Add real authentication here
        findNavController().navigate(R.id.action_login_to_home)
    }

    private fun goToForgot() {
        findNavController().navigate(R.id.action_login_to_forgot)
    }

    private fun goToCreate() {
        findNavController().navigate(R.id.action_login_to_createAccount)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
