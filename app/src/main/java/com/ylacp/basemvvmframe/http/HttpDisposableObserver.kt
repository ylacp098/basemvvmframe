package com.dfzw.dfzwmanageproject.http

import com.dfzw.dfzwmanageproject.utils.LogUtils
import io.reactivex.observers.DisposableObserver

open class HttpDisposableObserver<T> : DisposableObserver<T>() {
    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        HttpLoadDialogUtils.hidDialog()
        LogUtils.i("网络请求错误：${e}")
    }

    override fun onComplete() {
        HttpLoadDialogUtils.hidDialog()
    }

    open fun onSuccess(t: T) {
        HttpLoadDialogUtils.hidDialog()
    }


}