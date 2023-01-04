package id.ac.unand.klp_7_ptb_tb

import android.os.Parcel
import android.os.Parcelable

data class mahasiswa (
    val name:String,
    val nim:String,
    val agency : String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(nim)
        parcel.writeString(agency)
    }

    companion object CREATOR : Parcelable.Creator<mahasiswa> {
        override fun createFromParcel(parcel: Parcel): mahasiswa {
            return mahasiswa(parcel)
        }

        override fun newArray(size: Int): Array<mahasiswa?> {
            return arrayOfNulls(size)
        }
    }
}