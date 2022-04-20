package com.petru.homedevicesir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.petru.homedevicesir.data.QWButton
import com.petru.homedevicesir.databinding.ItemCommandBinding

class AdapterCommand(private val onClickItem: (QWButton) -> Unit)  : ListAdapter<QWButton, AdapterCommand.ViewHolder>(DIFF_CALLBACK)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCommandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onClickItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(val binding: ItemCommandBinding, private val onClickItem: (QWButton) -> Unit) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: QWButton) {
            binding.commandName.setText(item.name)
            binding.commandName.setOnClickListener {
                onClickItem(item)
            }
        }
    }

}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<QWButton>() {

    override fun areContentsTheSame(
        oldItem: QWButton,
        newItem: QWButton
    ): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(
        oldItem: QWButton,
        newItem: QWButton
    ): Boolean {
        return oldItem.name == newItem.name
    }
}