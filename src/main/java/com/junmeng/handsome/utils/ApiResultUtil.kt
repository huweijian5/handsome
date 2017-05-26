package com.junmeng.handsome.utils

import com.junmeng.handsome.domain.ApiResult


/**
 * Created by hwj on 2017/5/21.
 */
object ApiResultUtil {
    fun <T> success(data: T?): ApiResult<T> {
        var result = ApiResult<T>(1,"success",data)
        return result
    }

    fun <T> success(): ApiResult<T> {
        return success(null)
    }

    fun <T> error(errorCode: Int, message: String?): ApiResult<T> {
        val result = ApiResult<T>(errorCode,message)
        return result
    }

    fun <T> error(errorCode: Int, message: String, data: T): ApiResult<T> {
        val result = ApiResult<T>(errorCode,message,data)
        return result
    }
}