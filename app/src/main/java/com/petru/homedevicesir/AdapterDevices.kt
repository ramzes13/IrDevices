package com.petru.homedevicesir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.petru.homedevicesir.data.QWDevice
import com.petru.homedevicesir.databinding.ItemDeviceBinding

class AdapterDevices(private val onClickItem: (QWDevice) -> Unit)  : ListAdapter<QWDevice, AdapterDevices.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDeviceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onClickItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(val binding: ItemDeviceBinding, private val onClickItem: (QWDevice) -> Unit) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: QWDevice) {
            binding.deviceName.setText(item.name)
            binding.deviceName.setOnClickListener {
                onClickItem(item)
            }
        }
    }
}


private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<QWDevice>() {

    override fun areContentsTheSame(
        oldItem: QWDevice,
        newItem: QWDevice
    ): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(
        oldItem: QWDevice,
        newItem: QWDevice
    ): Boolean {
        return oldItem.name == newItem.name
    }
}