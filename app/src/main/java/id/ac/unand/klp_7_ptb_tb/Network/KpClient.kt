package id.ac.unand.klp_7_ptb_tb.Network

import id.ac.unand.klp_7_ptb_tb.models.*
import retrofit2.Call
import retrofit2.http.*

interface KpClient {
    @FormUrlEncoded
    @POST("/api/login/")
    fun login(@Field("username") username: String, @Field("password") password:String): Call<LoginResponse>;

    @POST("/api/logout")
    fun logout(): Call<LogoutResponse>

    @GET("/api/me")
    fun profile(@Header("Authorization") token:String):Call<ProfileResponse>

    @POST("/api/me/update")
    fun updateProfile(@Field("email") email: String, @Field("name") name:String): Call<UpdateProfileResponse>

    @POST("/api/password")
    fun changePassword(@Field("old_password") old_password: String, @Field("new_password") new_password:String, @Field("confirm_password") confirm_password:String): Call<ChangePasswordResponse>
}