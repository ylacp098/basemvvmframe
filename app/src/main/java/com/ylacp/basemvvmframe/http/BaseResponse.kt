package com.dfzw.dfzwmanageproject.http

class BaseResponse<T> {
    val data: T? = null
    val errorCode: Int? = null
    val errorMsg: String? = null

}