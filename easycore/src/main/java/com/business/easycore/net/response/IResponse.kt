package com.business.easycore.net.response

import okhttp3.ResponseBody

/**
 * Note:{ 请求响应体 }
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-04-17
 */
open class IResponse(
    var resultMsg: String,
    var body: ResponseBody? = null
) {

    internal fun buildFailed(resultMsg: String) {
        this.resultMsg = resultMsg
    }

    internal fun buildSuccess(body: ResponseBody) {
        resultMsg = ""
        this.body = body
    }

    constructor() : this("未知错误")

    fun isSuccess() = resultMsg.isEmpty()

}