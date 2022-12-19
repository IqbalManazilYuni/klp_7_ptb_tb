package id.ac.unand.klp_7_ptb_tb.models

import com.google.gson.annotations.SerializedName

data class Authorisation(

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("token")
    val token: String? = null
)