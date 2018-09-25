package com.xiongch.lib_common.http

import io.reactivex.functions.Function

class ApiModelFilterFunc<T> : Function<BaseModel<T>, T> {

    override fun apply(result: BaseModel<T>): T {
        if (!result.success()) {
            throw APIException(result.msg)
        }
        return if (result.data == null)
            Any() as T
        else
            result.data!!
    }

}