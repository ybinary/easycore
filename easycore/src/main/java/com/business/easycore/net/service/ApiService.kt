package com.business.easycore.net.service

import com.business.easycore.net.response.IFileDownloadResponse
import com.business.easycore.net.response.IFileUploadResponse
import com.business.easycore.net.response.IResponse
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * Note:{}
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-04-17
 */
interface ApiService {

    @GET
    suspend fun get(@Url url: String, @QueryMap params: Map<String, String>): ResponseBody

    @POST
    suspend fun post(@Url url: String, @Body body: Any): ResponseBody

    @GET
    suspend fun downloadFile(@Url url: String, @QueryMap params: Map<String, Any>): IFileUploadResponse

    @Multipart
    @POST
    suspend fun uploadFile(@Url url: String, @PartMap files: Map<String, RequestBody>): IFileDownloadResponse

}