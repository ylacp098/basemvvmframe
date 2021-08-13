package com.dfzw.dfzwmanageproject.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *
 */
abstract class MyBaseActivity<VM : ViewModel, T : ViewDataBinding> : AppCompatActivity() {
    var mContext: Context? = null

    lateinit var dataBing: T
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置为竖屏模式
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        mContext = this@MyBaseActivity

        dataBing = DataBindingUtil.setContentView(this, getLayoutId())

        initViewModel()
        initView(savedInstanceState)
        initDataObserver()

        initData()
    }


    protected open fun initView(savedInstanceState: Bundle?) {

    }

    protected open fun initData() {

    }

    abstract fun getLayoutId(): Int

    abstract fun initDataObserver()

    abstract fun initViewModel()


}