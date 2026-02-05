package com.mining.safety.ui.course

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
import com.mining.safety.databinding.FragmentCourseBinding
import com.mining.safety.model.Course
import com.mining.safety.viewmodel.CourseViewModel
import kotlinx.coroutines.launch

class CourseFragment : Fragment() {

    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CourseViewModel by lazy { CourseViewModel() }
    private lateinit var adapter: CourseAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
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
        adapter = CourseAdapter { course ->
            showCourseDialog(course)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@CourseFragment.adapter
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.courseList.collect { courses ->
                adapter.submitList(courses)
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
            showCourseDialog(null)
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadCourseList()
        }
    }

    private fun showCourseDialog(course: Course?) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_course, null)
        val etName = dialogView.findViewById<EditText>(R.id.etName)
        val spType = dialogView.findViewById<Spinner>(R.id.spType)
        val etDuration = dialogView.findViewById<EditText>(R.id.etDuration)
        val etTrainer = dialogView.findViewById<EditText>(R.id.etTrainer)
        val etDescription = dialogView.findViewById<EditText>(R.id.etDescription)

        // 设置课程类型
        val types = arrayOf("线上课程", "线下课程", "混合课程")
        spType.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, types)

        course?.let {
            etName.setText(it.name)
            etDuration.setText(it.duration)
            etTrainer.setText(it.trainer)
            etDescription.setText(it.description)
            spType.setSelection(types.indexOf(it.type))
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(if (course == null) "添加培训课程" else "编辑培训课程")
            .setView(dialogView)
            .setPositiveButton("保存") { _, _ ->
                val newCourse = Course(
                    id = course?.id ?: 0,
                    name = etName.text.toString(),
                    type = spType.selectedItem.toString(),
                    duration = etDuration.text.toString(),
                    trainer = etTrainer.text.toString(),
                    description = etDescription.text.toString(),
                    status = 1
                )
                if (course == null) {
                    viewModel.addCourse(newCourse)
                } else {
                    viewModel.updateCourse(newCourse)
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
