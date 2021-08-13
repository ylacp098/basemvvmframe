package com.dfzw.dfzwmanageproject.http

import io.reactivex.android.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitUtils {
    /**
     * baseurl,
     */
    var BASE_URL_PRO: String = ""

    var retrofit: Retrofit? = null

    inline fun <reified T : ApiService> getService(): T {
        if (retrofit == null || retrofit?.baseUrl().toString() != HttpConfig.BASE_URL_PRO) {
            var httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            //增加日志拦截器
            var logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.BASIC
            }
            httpClientBuilder.addInterceptor(logging)
            retrofit = Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build()
        }
        return retrofit!!.create(T::class.java)
    }


}

