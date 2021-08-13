package com.dfzw.dfzwmanageproject.http

interface ApiService {
    /**
     *示例
    @FormUrlEncoded
    @POST("a/mes/loginUser")
    fun userLogin(
        @Field("loginName") loginName: String,
        @Field("password") password: String
    ): Observable<LoginResponse>


    @GET("a/mes/selectGiveGoodsList")
    fun selectGiveGoodsList(@Query("sysUserId") sysUserId: String): Observable<GiftModel>


    @FormUrlEncoded
    @POST("a/mes/saveContract")
    fun saveContract(
        @FieldMap map: Map<String, @JvmSuppressWildcards Any>
    ): Observable<MyBaseModel>


    //上传多张图片
    @Multipart
    @POST("a/mes/uploadCommonImgMore")
    fun uploadCommonImgMore(
        @Part files: List<MultipartBody.Part>
    ): Observable<MyBaseModel>

     */



}