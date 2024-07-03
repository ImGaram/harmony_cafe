package com.harmony6.harmony_cafe.data

import java.time.LocalDate

data class Menu(
    val name: String, val desc: String, val img: Int,
    val username: String,
    val createdDate: LocalDate,
    val components: List<Components>
) {
    init {
        menuList.add(this)
    }

    data class Components(val name: String, val desc: String, val img: Int)

    companion object {
        val menuList = hashSetOf<Menu>()
    }
}