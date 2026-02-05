package com.mining.safety.ui.classroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mining.safety.databinding.ItemClassroomBinding
import com.mining.safety.model.Classroom

class ClassroomAdapter(
    private val onItemClick: (Classroom) -> Unit,
    private val onSignClick: (Classroom) -> Unit
) : ListAdapter<Classroom, ClassroomAdapter.ClassroomViewHolder>(ClassroomDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassroomViewHolder {
        val binding = ItemClassroomBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ClassroomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClassroomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ClassroomViewHolder(
        private val binding: ItemClassroomBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(classroom: Classroom) {
            binding.apply {
                tvName.text = classroom.name
                tvTrainer.text = "培训师: ${classroom.trainer}"
                tvLocation.text = "地点: ${classroom.location}"
                tvTime.text = "时间: ${classroom.startTime} - ${classroom.endTime}"
                tvParticipants.text = "人数: ${classroom.participantCount}/${classroom.maxParticipants}"
                tvStatus.text = when (classroom.status) {
                    0 -> "未开始"
                    1 -> "进行中"
                    2 -> "已结束"
                    else -> "未知"
                }

                root.setOnClickListener {
                    onItemClick(classroom)
                }

                btnSign.setOnClickListener {
                    onSignClick(classroom)
                }
            }
        }
    }

    class ClassroomDiffCallback : DiffUtil.ItemCallback<Classroom>() {
        override fun areItemsTheSame(oldItem: Classroom, newItem: Classroom): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Classroom, newItem: Classroom): Boolean {
            return oldItem == newItem
        }
    }
}
