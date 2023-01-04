package id.ac.unand.klp_7_ptb_tb.models

import com.google.gson.annotations.SerializedName

data class SeminarInItem (

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("nim")
        val nim: String? = null,

        @field:SerializedName("agency")
        val agency: String? = null,

        @field:SerializedName("title")
        val title: Any? = null,

        @field:SerializedName("start_at")
        val startAt: Any? = null,

        @field:SerializedName("end_at")
        val endAt: Any? = null,

        @field:SerializedName("status")
        val status: Int? = null,

        @field:SerializedName("supervisor_id")
        val supervisorId: Any? = null,

        @field:SerializedName("supervisor")
        val supervisor: Any? = null,

)