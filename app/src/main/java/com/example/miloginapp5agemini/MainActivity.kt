package com.example.miloginapp5agemini

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miloginapp5agemini.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener {
            validateAndLogin()
        }

        binding.imgFacebook.setOnClickListener {
            Toast.makeText(this, "Login con Facebook seleccionado", Toast.LENGTH_SHORT).show()
        }

        binding.imgInstagram.setOnClickListener {
            Toast.makeText(this, "Login con Instagram seleccionado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateAndLogin() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        when {
            username.isEmpty() -> {
                binding.etUsername.error = getString(R.string.error_empty_username)
                binding.etUsername.requestFocus()
            }
            password.isEmpty() -> {
                binding.etPassword.error = getString(R.string.error_empty_password)
                binding.etPassword.requestFocus()
            }
            else -> {
                Toast.makeText(
                    this,
                    getString(R.string.success_login),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
