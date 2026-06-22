package com.stride.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.stride.app.databinding.FragmentCreateAccountBinding

class CreateAccountFragment : BaseFragment() {

    private var _binding: FragmentCreateAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
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
        // Portrait
        binding.btnCreateP.setOnClickListener { attemptCreate() }
        binding.goToLoginP.setOnClickListener { goToLogin() }
        binding.btnGoogleP.setOnClickListener { Toast.makeText(requireContext(), "Google Sign-Up coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnAppleP.setOnClickListener { Toast.makeText(requireContext(), "Apple Sign-Up coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnFacebookP.setOnClickListener { Toast.makeText(requireContext(), "Facebook Sign-Up coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnInstagramP.setOnClickListener { Toast.makeText(requireContext(), "Instagram Sign-Up coming soon", Toast.LENGTH_SHORT).show() }

        // Landscape
        binding.btnCreateL.setOnClickListener { attemptCreate() }
        binding.goToLoginL.setOnClickListener { goToLogin() }
        binding.btnGoogleL.setOnClickListener { Toast.makeText(requireContext(), "Google Sign-Up coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnAppleL.setOnClickListener { Toast.makeText(requireContext(), "Apple Sign-Up coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnFacebookL.setOnClickListener { Toast.makeText(requireContext(), "Facebook Sign-Up coming soon", Toast.LENGTH_SHORT).show() }
        binding.btnInstagramL.setOnClickListener { Toast.makeText(requireContext(), "Instagram Sign-Up coming soon", Toast.LENGTH_SHORT).show() }
    }

    private fun attemptCreate() {
        val isPortrait = binding.portraitLayout.visibility == View.VISIBLE

        val name = if (isPortrait) binding.nameInputP.text.toString().trim() else binding.nameInputL.text.toString().trim()
        val email = if (isPortrait) binding.emailInputP.text.toString().trim() else binding.emailInputL.text.toString().trim()
        val password = if (isPortrait) binding.passwordInputP.text.toString() else binding.passwordInputL.text.toString()
        val confirm = if (isPortrait) binding.confirmInputP.text.toString() else binding.confirmInputL.text.toString()

        when {
            name.isEmpty() -> Toast.makeText(requireContext(), "Please enter your name", Toast.LENGTH_SHORT).show()
            email.isEmpty() -> Toast.makeText(requireContext(), "Please enter your email", Toast.LENGTH_SHORT).show()
            password.isEmpty() -> Toast.makeText(requireContext(), "Please enter a password", Toast.LENGTH_SHORT).show()
            password.length < 6 -> Toast.makeText(requireContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
            password != confirm -> Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT).show()
            else -> {
                // TODO: Add real account creation here
                findNavController().navigate(R.id.action_createAccount_to_home)
            }
        }
    }

    private fun goToLogin() {
        findNavController().navigate(R.id.action_createAccount_to_login)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
