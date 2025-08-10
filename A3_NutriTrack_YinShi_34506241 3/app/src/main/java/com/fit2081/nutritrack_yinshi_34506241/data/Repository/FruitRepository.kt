package com.fit2081.nutritrack_yinshi_34506241.data.Repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.fit2081.nutritrack_yinshi_34506241.data.Fruit.FruitAPI
import com.fit2081.nutritrack_yinshi_34506241.data.Fruit.FruitResponse

class FruitRepository(private val applicationContext: Context) {
    private val fruitAPI = FruitAPI.create()

    suspend fun getFruit(name: String): FruitResponse? {
        val response = fruitAPI.getFruit(name)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

    fun isNetworkAvailable(): Boolean {
        // Get the ConnectivityManager system service
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // Check if the device has an active network
        val network = connectivityManager.activeNetwork ?: return false
        // Get the network capabilities for the active network
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        // Check if the network has any of the following transports:
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    }

}