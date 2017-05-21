package com.junmeng.handsome.utils

import com.junmeng.handsome.domain.Result


/**
 * Created by hwj on 2017/5/21.
 */
object ResultUtil {
    fun <T> success(data: T?): Result<T> {
        var result = Result<T>(1,"success",data)
        return result
    }

    fun <T> success(): Result<T> {
        return success(null)
    }

    fun <T> error(errorCode: Int, message: String?): Result<T> {
        val result = Result<T>(errorCode,message)
        return result
    }

    fun <T> error(errorCode: Int, message: String, data: T): Result<T> {
        val result = Result<T>(errorCode,message,data)
        return result
    }
}