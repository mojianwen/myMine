package com.mining.safety.ui.topic

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
import com.mining.safety.databinding.FragmentTopicBinding
import com.mining.safety.model.Topic
import com.mining.safety.viewmodel.TopicViewModel
import kotlinx.coroutines.launch

class TopicFragment : Fragment() {

    private var _binding: FragmentTopicBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TopicViewModel by lazy { TopicViewModel() }
    private lateinit var adapter: TopicAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopicBinding.inflate(inflater, container, false)
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
        adapter = TopicAdapter { topic ->
            showTopicDialog(topic)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TopicFragment.adapter
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.topicList.collect { topics ->
                adapter.submitList(topics)
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
            showTopicDialog(null)
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadTopicList()
        }
    }

    private fun showTopicDialog(topic: Topic?) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_topic, null)
        val etName = dialogView.findViewById<EditText>(R.id.etName)
        val spCategory = dialogView.findViewById<Spinner>(R.id.spCategory)
        val etDescription = dialogView.findViewById<EditText>(R.id.etDescription)

        // 设置专题分类
        val categories = arrayOf("安全基础", "专业技能", "法律法规", "事故预防")
        spCategory.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)

        topic?.let {
            etName.setText(it.name)
            etDescription.setText(it.description)
            spCategory.setSelection(categories.indexOf(it.category))
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(if (topic == null) "添加培训专题" else "编辑培训专题")
            .setView(dialogView)
            .setPositiveButton("保存") { _, _ ->
                val newTopic = Topic(
                    id = topic?.id ?: 0,
                    name = etName.text.toString(),
                    category = spCategory.selectedItem.toString(),
                    description = etDescription.text.toString(),
                    status = 1
                )
                if (topic == null) {
                    viewModel.addTopic(newTopic)
                } else {
                    viewModel.updateTopic(newTopic)
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
