package com.harmony6.harmony_cafe.data

import android.os.Parcel
import android.os.Parcelable
import java.time.LocalDate

data class Components(val name: String, val desc: String, val img: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(desc)
        parcel.writeInt(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Components> {
        override fun createFromParcel(parcel: Parcel): Components {
            return Components(parcel)
        }

        override fun newArray(size: Int): Array<Components?> {
            return arrayOfNulls(size)
        }
    }
}

data class Menu(
    val name: String, val desc: String, val img: Int,
    val username: String,
    val createdDate: LocalDate,
    val components: List<Components> = listOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readValue(LocalDate::class.java.classLoader) as LocalDate,
        parcel.createTypedArrayList(Components.CREATOR) ?: listOf()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(desc)
        parcel.writeInt(img)
        parcel.writeString(username)
        parcel.writeValue(createdDate)
        parcel.writeTypedList(components)
    }

    companion object CREATOR : Parcelable.Creator<Menu> {
        override fun createFromParcel(parcel: Parcel): Menu {
            return Menu(parcel)
        }

        override fun newArray(size: Int): Array<Menu?> {
            return arrayOfNulls(size)
        }
    }
}