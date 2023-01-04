package id.ac.unand.klp_7_ptb_tb.Network

import id.ac.unand.klp_7_ptb_tb.DashboardKp
import id.ac.unand.klp_7_ptb_tb.models.*
import id.ac.unand.tb_klp_7.MahasiswaAdapter
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET

interface KpClient {
    @FormUrlEncoded
    @POST("/api/login/")
    fun login(@Field("username") username: String, @Field("password") password:String): Call<LoginResponse>;

    @POST("/api/logout")
    fun logout(@Header("Authorization") token: String): Call<LogoutResponse>

    @GET("/api/me")
    fun profile(@Header("Authorization") token:String):Call<ProfileResponse>

    @FormUrlEncoded
    @POST("/api/me/update")
    fun updateProfile(
        @Header("Authorization") token:String,
        @Field("name") name:String,
        @Field("email") email:String
    ): Call<UpdateProfileResponse>

    @FormUrlEncoded
    @POST("/api/password")
    fun changePassword(
        @Header("Authorization") token: String,
        @Field("old_password") old_password: String,
        @Field("new_password") new_password: String,
        @Field("confirm_password") confirm_password: String,
    )
    : Call<ChangePasswordResponse>

    @GET("/api/internship-students")
    fun getMahasiswa(@Header("Authorization") token:String) : Call<MahasiswaResponse>

}