package com.midterm.securevpnproxy.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.databinding.FragmentLoginBinding
import com.midterm.securevpnproxy.home.HomeActivity


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
            showKeyBoard(etPassword)
            etPassword.setOnEditorActionListener { textView, i, keyEvent ->
                if (i == EditorInfo.IME_ACTION_DONE) {
                    hideKeyBoard(etPassword)
                    true
                } else {
                    false
                }
            }

            btnLogin.setOnClickListener {
                if (etPassword.text.isBlank()) {
                    Toast.makeText(context, "Password can not be empty!", Toast.LENGTH_LONG).show()
                    setErrorEditText(true)
                } else {
                    if (etPassword.text.toString() == getString(R.string.password)) {
                        setErrorEditText(false)
                        reinitializeUI()
                        val intent =
                            Intent(this@LoginFragment.requireContext(), HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        setErrorEditText(true)
                        Toast.makeText(context, "Password wrong!", Toast.LENGTH_LONG).show()
                    }

                }
            }
            tvForgotPassword.setOnClickListener {
                val action = LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment()
                findNavController().navigate(action)
            }
            tvNavigateToRegister.setOnClickListener {
                val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
                findNavController().navigate(action)
            }

            imageDisplayPassword.setOnClickListener {
                if (etPassword.transformationMethod == PasswordTransformationMethod.getInstance()) {
                    imageDisplayPassword.setImageResource(R.drawable.ic_hide_password)
                    etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                } else {
                    etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    imageDisplayPassword.setImageResource(R.drawable.ic_display_password)
                }
            }
        }
    }

    private fun setErrorEditText(error: Boolean) {
        if (error) {
            binding.tvError.visibility = View.VISIBLE
            binding.etPassword.setBackgroundResource(R.drawable.bg_edit_text_error)
        } else {
            binding.tvError.visibility = View.GONE
            binding.etPassword.setBackgroundResource(R.drawable.bg_edit_text)
        }
    }

    private fun reinitializeUI() {
        binding.apply {
            etEmail.text.clear()
            etPassword.text.clear()
            imageDisplayPassword.setImageResource(R.drawable.ic_display_password)
            etEmail.requestFocus()
        }
    }


    private fun showKeyBoard(editText: EditText) {
        val manager: InputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.showSoftInput(editText.rootView, InputMethodManager.SHOW_IMPLICIT)
    }

    private fun hideKeyBoard(editText: EditText) {
        val manager: InputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(editText.applicationWindowToken, 0)
    }

}