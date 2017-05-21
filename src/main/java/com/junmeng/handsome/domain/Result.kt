package com.junmeng.handsome.domain

/**
 * Created by hwj on 2017/5/21.
 */
data  class Result<T>(
        var code: Int = -1,
        var message: String? = "",
        var data: T? = null) {

    constructor():this(code=-1,message="",data=null){}
}