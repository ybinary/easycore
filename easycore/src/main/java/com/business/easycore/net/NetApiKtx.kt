package com.business.easycore.net

import android.util.Log
import com.business.easycore.net.request.IRequest
import com.business.easycore.net.response.IResponse
import com.business.easycore.net.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.lang.ClassCastException
import java.lang.Exception
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

object NetApiKtx {

    private var baseUrl = ""

    private val okHttpClient = OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).build()

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient).build()
    }

    private val apiService by lazy(LazyThreadSafetyMode.PUBLICATION) {
        retrofit.create(ApiService::class.java)
    }

    fun init(baseUrl: String) {
        retrofit.newBuilder().baseUrl(baseUrl).client(okHttpClient).build()
    }

    @Suppress("UNCHECKED_CAST")
    suspend fun get(iRequest: IRequest): IResponse = withContext(Dispatchers.IO) {
        try {
            var response =
                apiService.get(iRequest.getUrl(), iRequest.getParams() as Map<String, String>)
            Log.d("response", response.string())
            IResponse().buildSuccess(response)
        } catch (e: Exception) {
            IResponse().buildFailed(e.toString())
        }
        IResponse()
    }

    suspend fun post(iRequest: IRequest): IResponse = withContext(Dispatchers.IO) {
        try {
            var response = apiService.post(iRequest.getUrl(), iRequest.getParams())
            Log.d("response", response.string())
            IResponse().buildSuccess(response)
        } catch (e: Exception) {
            IResponse().buildFailed(e.toString())
        }
        IResponse()
    }

}