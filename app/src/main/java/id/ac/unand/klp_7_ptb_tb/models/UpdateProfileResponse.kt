package id.ac.unand.klp_7_ptb_tb.models

import com.google.gson.annotations.SerializedName

data class UpdateProfileResponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)