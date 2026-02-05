package com.mining.safety.ui.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mining.safety.databinding.ItemCourseBinding
import com.mining.safety.model.Course

class CourseAdapter(
    private val onItemClick: (Course) -> Unit
) : ListAdapter<Course, CourseAdapter.CourseViewHolder>(CourseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CourseViewHolder(
        private val binding: ItemCourseBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(course: Course) {
            binding.apply {
                tvName.text = course.name
                tvType.text = course.type
                tvDuration.text = course.duration
                tvTrainer.text = course.trainer
                tvDescription.text = course.description
                tvStatus.text = if (course.status == 1) "正常" else "禁用"

                root.setOnClickListener {
                    onItemClick(course)
                }
            }
        }
    }

    class CourseDiffCallback : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem == newItem
        }
    }
}
