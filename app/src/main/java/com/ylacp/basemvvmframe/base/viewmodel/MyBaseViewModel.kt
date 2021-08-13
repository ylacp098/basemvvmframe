package com.dfzw.dfzwmanageproject.base.viewmodel

import androidx.lifecycle.ViewModel
import com.dfzw.dfzwmanageproject.http.ApiService
import com.dfzw.dfzwmanageproject.http.RetrofitUtils


abstract class MyBaseViewModel<T:ApiService> : ViewModel() {

    protected val apiService: T by lazy {
        RetrofitUtils.getService()
    }
}