package id.ac.unand.klp_7_ptb_tb.models

import com.google.gson.annotations.SerializedName

data class MahasiswaResponse (
        @field:SerializedName("seminar")
        val SeminarInItem: List<SeminarInItem?>? = null,

        @field:SerializedName("count")
        val count: Int? = null,

        @field:SerializedName("status")
        val status: String? = null
        )