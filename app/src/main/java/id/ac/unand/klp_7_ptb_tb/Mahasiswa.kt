package id.ac.unand.klp_7_ptb_tb

import android.os.Parcel
import android.os.Parcelable

data class mahasiswa (
    val imgview:Int,
    val nama_mahasiswa:String,
    val nim_mahasiswa:String,
    val lokasi_kp : String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imgview)
        parcel.writeString(nama_mahasiswa)
        parcel.writeString(nim_mahasiswa)
        parcel.writeString(lokasi_kp)
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