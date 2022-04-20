package com.petru.homedevicesir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.petru.homedevicesir.data.QWDevice
import com.petru.homedevicesir.data.RepositoryDevices
import com.petru.homedevicesir.databinding.FragmentDeviceBinding


class DeviceFragment : Fragment() {

    private var _binding: FragmentDeviceBinding? = null
    private val binding get() = _binding!!
    private val adapterDevices = AdapterDevices(::onClickItem)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDeviceBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.devicesRecyclerView.adapter = adapterDevices
        val repositoryDevices = RepositoryDevices()
        adapterDevices.submitList(repositoryDevices.getDevices(requireContext()))
    }

    private fun onClickItem(item:QWDevice) {

        activity?.findNavController(R.id.nav_host_bottom_container)
        val navController = activity?.findNavController(R.id.nav_host_bottom_container)
        val bundle = bundleOf("deviceName" to item.name)
        navController?.navigate(R.id.fragment_command,bundle)
    }


}