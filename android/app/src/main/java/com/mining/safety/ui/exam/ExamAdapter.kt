package com.mining.safety.ui.exam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mining.safety.databinding.ItemExamBinding
import com.mining.safety.model.Exam

class ExamAdapter(
    private val onItemClick: (Exam) -> Unit
) : ListAdapter<Exam, ExamAdapter.ExamViewHolder>(ExamDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamViewHolder {
        val binding = ItemExamBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExamViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ExamViewHolder(
        private val binding: ItemExamBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(exam: Exam) {
            binding.apply {
                tvName.text = exam.name
                tvType.text = exam.type
                tvTotalScore.text = "总分: ${exam.totalScore}"
                tvDuration.text = "时长: ${exam.duration}分钟"
                tvQuestionCount.text = "题目数: ${exam.questionCount}"
                tvStatus.text = if (exam.status == 1) "正常" else "禁用"

                root.setOnClickListener {
                    onItemClick(exam)
                }
            }
        }
    }

    class ExamDiffCallback : DiffUtil.ItemCallback<Exam>() {
        override fun areItemsTheSame(oldItem: Exam, newItem: Exam): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Exam, newItem: Exam): Boolean {
            return oldItem == newItem
        }
    }
}
