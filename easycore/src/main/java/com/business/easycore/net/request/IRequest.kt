package com.business.easycore.net.request

/**
 * Note:{ 请求实体 }
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-04-17
 */
open class IRequest(
    private var requestUrl: String,
    var requestParams: Any = mutableMapOf<String, Any>()
) : IRequestInner {

    override fun getUrl(): String = requestUrl

    override fun getParams(): Any = requestParams

}