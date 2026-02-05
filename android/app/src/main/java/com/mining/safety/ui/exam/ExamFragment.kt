package com.mining.safety.ui.exam

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
import com.mining.safety.databinding.FragmentExamBinding
import com.mining.safety.model.Exam
import com.mining.safety.viewmodel.ExamViewModel
import kotlinx.coroutines.launch

class ExamFragment : Fragment() {

    private var _binding: FragmentExamBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ExamViewModel by lazy { ExamViewModel() }
    private lateinit var adapter: ExamAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExamBinding.inflate(inflater, container, false)
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
        adapter = ExamAdapter { exam ->
            showExamDialog(exam)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ExamFragment.adapter
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.examList.collect { exams ->
                adapter.submitList(exams)
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
            showExamDialog(null)
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadExamList()
        }
    }

    private fun showExamDialog(exam: Exam?) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_exam, null)
        val etName = dialogView.findViewById<EditText>(R.id.etName)
        val spType = dialogView.findViewById<Spinner>(R.id.spType)
        val etTotalScore = dialogView.findViewById<EditText>(R.id.etTotalScore)
        val etDuration = dialogView.findViewById<EditText>(R.id.etDuration)
        val etQuestionCount = dialogView.findViewById<EditText>(R.id.etQuestionCount)

        // 设置试卷类型
        val types = arrayOf("安全知识", "操作技能", "应急处理", "综合测试")
        spType.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, types)

        exam?.let {
            etName.setText(it.name)
            etTotalScore.setText(it.totalScore.toString())
            etDuration.setText(it.duration.toString())
            etQuestionCount.setText(it.questionCount.toString())
            spType.setSelection(types.indexOf(it.type))
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(if (exam == null) "添加培训试卷" else "编辑培训试卷")
            .setView(dialogView)
            .setPositiveButton("保存") { _, _ ->
                val newExam = Exam(
                    id = exam?.id ?: 0,
                    name = etName.text.toString(),
                    type = spType.selectedItem.toString(),
                    totalScore = etTotalScore.text.toString().toIntOrNull() ?: 0,
                    duration = etDuration.text.toString().toIntOrNull() ?: 0,
                    questionCount = etQuestionCount.text.toString().toIntOrNull() ?: 0,
                    status = 1
                )
                if (exam == null) {
                    viewModel.addExam(newExam)
                } else {
                    viewModel.updateExam(newExam)
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
