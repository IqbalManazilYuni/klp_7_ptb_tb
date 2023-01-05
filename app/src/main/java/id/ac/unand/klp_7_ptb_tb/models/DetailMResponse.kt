package id.ac.unand.klp_7_ptb_tb.models

import com.google.gson.annotations.SerializedName

data class DetailMResponse(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("nim")
    val nim: String? = null,

    @field:SerializedName("agency")
    val agency: String? = null,

    @field:SerializedName("supervisor")
    val supervisor : String? = null
)
