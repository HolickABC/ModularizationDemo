package com.xiongch.lib_common.http

import java.io.Serializable

/**
 * Created by xiongchang on 17/6/27.
 */

class BaseModel<T> : Serializable {

    var data: T? = null
    var ok: Boolean = false
    var msg: String? = null

    fun success(): Boolean {
        //ok有时没有这个字段
        return ok
    }

}
