package com.mining.safety.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mining.safety.R
import com.mining.safety.databinding.ActivityLoginBinding
import com.mining.safety.ui.main.MainActivity
import com.mining.safety.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        observeLoginState()
    }

    private fun setupViews() {
        binding.etUsername.setText(viewModel.username.value)
        binding.etPassword.setText(viewModel.password.value)

        binding.etUsername.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onUsernameChange(binding.etUsername.text.toString())
            }
        }

        binding.etPassword.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onPasswordChange(binding.etPassword.text.toString())
            }
        }

        binding.btnLogin.setOnClickListener {
            viewModel.onUsernameChange(binding.etUsername.text.toString())
            viewModel.onPasswordChange(binding.etPassword.text.toString())
            viewModel.login()
        }
    }

    private fun observeLoginState() {
        lifecycleScope.launch {
            viewModel.loginState.collect { state ->
                when (state) {
                    is LoginViewModel.LoginState.Idle -> {
                        // 初始状态
                    }
                    is LoginViewModel.LoginState.Loading -> {
                        binding.btnLogin.isEnabled = false
                        binding.progressBar.visibility = android.view.View.VISIBLE
                    }
                    is LoginViewModel.LoginState.Success -> {
                        binding.btnLogin.isEnabled = true
                        binding.progressBar.visibility = android.view.View.GONE
                        Toast.makeText(
                            this@LoginActivity,
                            R.string.login_success,
                            Toast.LENGTH_SHORT
                        ).show()
                        // 保存token
                        val sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
                        sharedPreferences.edit()
                            .putString("token", state.response.token)
                            .putLong("userId", state.response.user.id)
                            .putString("username", state.response.user.username)
                            .apply()

                        // 跳转到主界面
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }
                    is LoginViewModel.LoginState.Error -> {
                        binding.btnLogin.isEnabled = true
                        binding.progressBar.visibility = android.view.View.GONE
                        Toast.makeText(
                            this@LoginActivity,
                            state.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}
