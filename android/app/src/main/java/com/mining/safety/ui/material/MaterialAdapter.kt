package com.mining.safety.ui.material

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mining.safety.databinding.ItemMaterialBinding
import com.mining.safety.model.Material

class MaterialAdapter(
    private val onItemClick: (Material) -> Unit
) : ListAdapter<Material, MaterialAdapter.MaterialViewHolder>(MaterialDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val binding = ItemMaterialBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MaterialViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MaterialViewHolder(
        private val binding: ItemMaterialBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(material: Material) {
            binding.apply {
                tvName.text = material.name
                tvType.text = material.type
                tvCategory.text = material.category
                tvDuration.text = material.duration
                tvStatus.text = if (material.status == 1) "正常" else "禁用"

                root.setOnClickListener {
                    onItemClick(material)
                }
            }
        }
    }

    class MaterialDiffCallback : DiffUtil.ItemCallback<Material>() {
        override fun areItemsTheSame(oldItem: Material, newItem: Material): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Material, newItem: Material): Boolean {
            return oldItem == newItem
        }
    }
}
