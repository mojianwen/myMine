package com.mining.safety.ui.material

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
import com.mining.safety.databinding.FragmentMaterialBinding
import com.mining.safety.model.Material
import com.mining.safety.viewmodel.MaterialViewModel
import kotlinx.coroutines.launch

class MaterialFragment : Fragment() {

    private var _binding: FragmentMaterialBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MaterialViewModel by lazy { MaterialViewModel() }
    private lateinit var adapter: MaterialAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMaterialBinding.inflate(inflater, container, false)
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
        adapter = MaterialAdapter { material ->
            showMaterialDialog(material)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@MaterialFragment.adapter
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.materialList.collect { materials ->
                adapter.submitList(materials)
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
            showMaterialDialog(null)
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadMaterialList()
        }
    }

    private fun showMaterialDialog(material: Material?) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_material, null)
        val etName = dialogView.findViewById<EditText>(R.id.etName)
        val spType = dialogView.findViewById<Spinner>(R.id.spType)
        val spCategory = dialogView.findViewById<Spinner>(R.id.spCategory)
        val etDuration = dialogView.findViewById<EditText>(R.id.etDuration)
        val etFilePath = dialogView.findViewById<EditText>(R.id.etFilePath)

        // 设置素材类型
        val types = arrayOf("视频", "文档", "图片", "音频")
        spType.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, types)

        // 设置素材分类
        val categories = arrayOf("安全规程", "事故案例", "技术培训", "应急演练")
        spCategory.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)

        material?.let {
            etName.setText(it.name)
            etDuration.setText(it.duration)
            etFilePath.setText(it.filePath)
            spType.setSelection(types.indexOf(it.type))
            spCategory.setSelection(categories.indexOf(it.category))
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(if (material == null) "添加培训素材" else "编辑培训素材")
            .setView(dialogView)
            .setPositiveButton("保存") { _, _ ->
                val newMaterial = Material(
                    id = material?.id ?: 0,
                    name = etName.text.toString(),
                    type = spType.selectedItem.toString(),
                    category = spCategory.selectedItem.toString(),
                    duration = etDuration.text.toString(),
                    filePath = etFilePath.text.toString(),
                    status = 1
                )
                if (material == null) {
                    viewModel.addMaterial(newMaterial)
                } else {
                    viewModel.updateMaterial(newMaterial)
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
