package com.xiongch.lib_common.http

/**
 * Created by xiongchang on 17/6/27.
 */

class APIException : RuntimeException {
    var code: Int = 0

    constructor(message: String?) : super(message) {}

    constructor(code: Int, message: String?) : super(message) {
        this.code = code
    }
}
