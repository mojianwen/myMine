package com.mining.safety.ui.classroom

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mining.safety.R
import com.mining.safety.databinding.FragmentClassroomBinding
import com.mining.safety.model.Classroom
import com.mining.safety.viewmodel.ClassroomViewModel
import kotlinx.coroutines.launch

class ClassroomFragment : Fragment() {

    private var _binding: FragmentClassroomBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ClassroomViewModel by lazy { ClassroomViewModel() }
    private lateinit var adapter: ClassroomAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassroomBinding.inflate(inflater, container, false)
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
        adapter = ClassroomAdapter(
            onItemClick = { classroom ->
                showClassroomDialog(classroom)
            },
            onSignClick = { classroom ->
                showSignDialog(classroom)
            }
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ClassroomFragment.adapter
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.classroomList.collect { classrooms ->
                adapter.submitList(classrooms)
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
            showClassroomDialog(null)
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadClassroomList()
        }
    }

    private fun showClassroomDialog(classroom: Classroom?) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_classroom, null)
        val etName = dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etName)
        val etTrainer = dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etTrainer)
        val etLocation = dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etLocation)
        val etStartTime = dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etStartTime)
        val etEndTime = dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEndTime)
        val etMaxParticipants = dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etMaxParticipants)
        val etDescription = dialogView.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etDescription)

        classroom?.let {
            etName.setText(it.name)
            etTrainer.setText(it.trainer)
            etLocation.setText(it.location)
            etStartTime.setText(it.startTime)
            etEndTime.setText(it.endTime)
            etMaxParticipants.setText(it.maxParticipants.toString())
            etDescription.setText(it.description)
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(if (classroom == null) "添加线下课堂" else "编辑线下课堂")
            .setView(dialogView)
            .setPositiveButton("保存") { _, _ ->
                val newClassroom = Classroom(
                    id = classroom?.id ?: 0,
                    name = etName.text.toString(),
                    trainer = etTrainer.text.toString(),
                    location = etLocation.text.toString(),
                    startTime = etStartTime.text.toString(),
                    endTime = etEndTime.text.toString(),
                    maxParticipants = etMaxParticipants.text.toString().toIntOrNull() ?: 0,
                    description = etDescription.text.toString(),
                    status = 1
                )
                if (classroom == null) {
                    viewModel.addClassroom(newClassroom)
                } else {
                    viewModel.updateClassroom(newClassroom)
                }
            }
            .setNegativeButton("取消", null)
            .create()

        dialog.show()
    }

    private fun showSignDialog(classroom: Classroom) {
        AlertDialog.Builder(requireContext())
            .setTitle("课堂签到")
            .setMessage("确定要为\"${classroom.name}\"签到吗？")
            .setPositiveButton("确定") { _, _ ->
                viewModel.signClassroom(classroom.id)
            }
            .setNegativeButton("取消", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
