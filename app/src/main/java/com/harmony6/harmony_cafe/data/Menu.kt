package com.harmony6.harmony_cafe.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class Components(val name: String, val desc: String, val img: Int) : Parcelable

@Parcelize
data class Menu(
    val name: String, val desc: String, val img: Int,
    val username: String,
    val createdDate: LocalDate,
    val components: List<Components> = listOf()
) : Parcelable