package com.mining.safety.ui.user

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mining.safety.R
import com.mining.safety.databinding.FragmentUserBinding
import com.mining.safety.model.User
import com.mining.safety.viewmodel.UserViewModel
import kotlinx.coroutines.launch

class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserViewModel by lazy { UserViewModel() }
    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
        setupFab()
        setupSwipeRefresh()
    }

    private fun setupRecyclerView() {
        adapter = UserAdapter { user ->
            showUserDialog(user)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@UserFragment.adapter
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.userList.collect { users ->
                adapter.submitList(users)
            }
        }

        lifecycleScope.launch {
            viewModel.loading.collect { isLoading ->
                binding.swipeRefresh.isRefreshing = isLoading
            }
        }

        lifecycleScope.launch {
            viewModel.error.collect { error ->
                error?.let {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupFab() {
        binding.fabAdd.setOnClickListener {
            showUserDialog(null)
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadUserList()
        }
    }

    private fun showUserDialog(user: User?) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_user, null)
        val etUsername = dialogView.findViewById<EditText>(R.id.etUsername)
        val etRealName = dialogView.findViewById<EditText>(R.id.etRealName)
        val etPhone = dialogView.findViewById<EditText>(R.id.etPhone)
        val etEmail = dialogView.findViewById<EditText>(R.id.etEmail)

        user?.let {
            etUsername.setText(it.username)
            etRealName.setText(it.realName)
            etPhone.setText(it.phone)
            etEmail.setText(it.email)
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(if (user == null) "添加用户" else "编辑用户")
            .setView(dialogView)
            .setPositiveButton("保存") { _, _ ->
                val newUser = User(
                    id = user?.id ?: 0,
                    username = etUsername.text.toString(),
                    realName = etRealName.text.toString(),
                    phone = etPhone.text.toString(),
                    email = etEmail.text.toString(),
                    status = 1
                )
                if (user == null) {
                    viewModel.addUser(newUser)
                } else {
                    viewModel.updateUser(newUser)
                }
            }
            .setNegativeButton("取消", null)
            .create()

        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
