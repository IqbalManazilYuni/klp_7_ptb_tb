package id.ac.unand.klp_7_ptb_tb.models

import com.google.gson.annotations.SerializedName

data class DetailMResponse(
    @field:SerializedName("internships")
    val internships: List<ListMahasiswa?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("supervisor")
    val supervisor : String? = null
)
