package com.junmeng.handsome.common


/**
 * 实际业务异常
 * spring 对RuntimeException才有事务回滚
 * Created by HWJ on 2017/3/19.
 */
 class BussinessException(message: String?) : RuntimeException(message) {
    var code:Int=-1
    constructor(code:ResultCode,message: String?):this(message){this.code=code.code}


}