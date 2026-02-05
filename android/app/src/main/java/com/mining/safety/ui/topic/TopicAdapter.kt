package com.mining.safety.ui.topic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mining.safety.databinding.ItemTopicBinding
import com.mining.safety.model.Topic

class TopicAdapter(
    private val onItemClick: (Topic) -> Unit
) : ListAdapter<Topic, TopicAdapter.TopicViewHolder>(TopicDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val binding = ItemTopicBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TopicViewHolder(
        private val binding: ItemTopicBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(topic: Topic) {
            binding.apply {
                tvName.text = topic.name
                tvCategory.text = topic.category
                tvDescription.text = topic.description
                tvCourseCount.text = "课程数: ${topic.courseCount}"
                tvMaterialCount.text = "素材数: ${topic.materialCount}"
                tvStatus.text = if (topic.status == 1) "正常" else "禁用"

                root.setOnClickListener {
                    onItemClick(topic)
                }
            }
        }
    }

    class TopicDiffCallback : DiffUtil.ItemCallback<Topic>() {
        override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
            return oldItem == newItem
        }
    }
}
