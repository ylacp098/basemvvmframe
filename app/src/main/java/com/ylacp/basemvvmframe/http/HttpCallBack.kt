package com.dfzw.dfzwmanageproject.http


sealed class HttpCallBack<out T>{
    data class Success<T>(val data:T)

    object Failed

}
