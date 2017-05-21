package com.junmeng.handsome.common


/**
 * Created by hwj on 2017/5/21.
 */
enum class ResultCode(code: Int, message: String) {

    UNKNOW(-1, "操作失败"),
    SUCCESS(1, "操作成功"),
    FAILED(-99, "未知错误");

    var code: Int = code
    var message: String = message


}