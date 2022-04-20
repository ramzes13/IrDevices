package com.petru.homedevicesir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.petru.homedevicesir.data.QWButton
import com.petru.homedevicesir.data.RepositoryDevices
import com.petru.homedevicesir.databinding.FragmentCommandBinding

class CommandFragment : Fragment() {

    private var _binding: FragmentCommandBinding? = null
    private val binding get() = _binding!!
    private val adapterCommand = AdapterCommand(::onClickItem)
    private var deviceName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { arguments->
            arguments.getString("deviceName")?.let {
                deviceName = it
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCommandBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.commandRecyclerView.adapter = adapterCommand

        val repositoryDevices = RepositoryDevices()
        val deviceModel = repositoryDevices.getDevice(requireContext(),deviceName)
        activity?.title = deviceModel.name

        adapterCommand.submitList(deviceModel.buttons)
    }

    private fun onClickItem(item: QWButton) {
        TODO("Acea cand faci click pe un item")

    }
}