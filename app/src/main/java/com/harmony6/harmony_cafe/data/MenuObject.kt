package com.harmony6.harmony_cafe.data

import android.content.Context
import com.harmony6.harmony_cafe.R
import java.time.LocalDate

object MenuObject {
    val menuList = mutableListOf<Menu>()

    fun Context.initMenu() {
        val menuNameList = listOf(
            getString(R.string.menu_name1),
            getString(R.string.menu_name2),
            getString(R.string.menu_name3),
            getString(R.string.menu_name4),
            getString(R.string.menu_name5)
        )
        val menuDescriptionList = listOf(
            getString(R.string.menu_desc1),
            getString(R.string.menu_desc2),
            getString(R.string.menu_desc3),
            getString(R.string.menu_desc4),
            getString(R.string.menu_desc5),
        )
        val menuComponentsNameList1 = listOf(
            getString(R.string.menu_components1_name1),
            getString(R.string.menu_components2_name1),
            getString(R.string.menu_components3_name1),
            getString(R.string.menu_components4_name1),
            getString(R.string.menu_components5_name1),
        )
        val menuComponentsNameList2 = listOf(
            getString(R.string.menu_components1_name2),
            getString(R.string.menu_components2_name2),
            getString(R.string.menu_components3_name2),
            getString(R.string.menu_components4_name2),
            getString(R.string.menu_components5_name2),
        )
        val menuComponentsDescList1 = listOf(
            getString(R.string.menu_components1_desc1),
            getString(R.string.menu_components2_desc1),
            getString(R.string.menu_components3_desc1),
            getString(R.string.menu_components4_desc1),
            getString(R.string.menu_components5_desc1),
        )
        val menuComponentsDescList2 = listOf(
            getString(R.string.menu_components1_desc2),
            getString(R.string.menu_components2_desc2),
            getString(R.string.menu_components3_desc2),
            getString(R.string.menu_components4_desc2),
            getString(R.string.menu_components5_desc2),
        )
        val userNameList = listOf("김보라", "김태영", "송유호", "임가람", "김보라")
        val menuSiteList = listOf(
            getString(R.string.menu_site1),
            getString(R.string.menu_site2),
            getString(R.string.menu_site3),
            getString(R.string.menu_site4),
            getString(R.string.menu_site5)
        )
        val menuImageList = listOf(
            R.drawable.img_bread_pudding,
            R.drawable.img_menu_taeyoung,
            R.drawable.img_menu_imgaram,
            R.drawable.img_component_ice_cream_crople,
            R.drawable.img_component_ice_cream_crople,
        )
        val menuComponentImageList = listOf(
            listOf(R.drawable.img_bread_pudding, R.drawable.home_feed_image1),
            listOf(
                R.drawable.img_component_ice_americano,
                R.drawable.img_component_strawberry_tiramisu
            ),
            listOf(R.drawable.home_feed_profile1, R.drawable.home_feed_profile1),
            listOf(
                R.drawable.img_component_grapefruit_ade,
                R.drawable.img_component_ice_cream_crople
            ),
            listOf(R.drawable.home_feed_profile1, R.drawable.home_feed_profile1)
        )

        for (i in menuNameList.indices) {
            val menu = Menu(
                name = menuNameList[i],
                desc = menuDescriptionList[i],
                img = menuImageList[i],
                createdDate = LocalDate.of(2024, 7, 2),
                site = menuSiteList[i],
                username = userNameList[i],
                components = listOf(
                    Components(
                        name = menuComponentsNameList1[i],
                        desc = menuComponentsDescList1[i],
                        img = menuComponentImageList[i][0]
                    ),
                    Components(
                        name = menuComponentsNameList2[i],
                        desc = menuComponentsDescList2[i],
                        img = menuComponentImageList[i][1]
                    ),
                )
            )
            menuList.add(menu)
        }
    }
}