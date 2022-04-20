package com.petru.homedevicesir.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RepositoryDevices {
    lateinit var ir:List<QWDevice>

    private fun load(context:Context) {

        val jsonString = context.assets.open("ir.json").bufferedReader().use { it.readText() }

        val listCountryType = object : TypeToken<List<QWDevice>>() {}.type
        ir = Gson().fromJson(jsonString, listCountryType)
    }

    fun getDevices(context:Context): List<QWDevice> {
        if (this::ir.isInitialized == false) {
            load(context)
        }

        return ir
    }

    fun getDevice(context:Context,deviceName:String): QWDevice {
        if (this::ir.isInitialized == false) {
            load(context)
        }

        return ir.first { it.name == deviceName }
    }
}