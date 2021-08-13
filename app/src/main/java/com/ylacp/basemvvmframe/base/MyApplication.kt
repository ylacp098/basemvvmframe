package com.dfzw.dfzwmanageproject.base

import android.app.Application
import androidx.multidex.MultiDex
import com.dfzw.dfzwmanageproject.utils.AppUtils
import com.dfzw.dfzwmanageproject.utils.Constant
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory


/**
 * MyApplication
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        mContext = this@MyApplication
        MultiDex.install(this)
        AppUtils.ansyIsDebug(this)

        regToWx()
    }

    companion object {
        var mContext: MyApplication? = null
    }


    // APP_ID 替换为你的应用从官方网站申请到的合法appID
    private val APP_ID = Constant.wxAppId

    // IWXAPI 是第三方app和微信通信的openApi接口
    private var api: IWXAPI? = null

    private fun regToWx() {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, APP_ID, true)

        // 将应用的appId注册到微信
        api!!.registerApp(APP_ID)

        //建议动态监听微信启动广播进行注册到微信
//        registerReceiver(object : BroadcastReceiver() {
//            override fun onReceive(context: Context?, intent: Intent?) {
//
//                // 将该app注册到微信
//                api!!.registerApp(Constant.wxAppId)
//            }
//        }, IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP))
    }

}