package com.harmony6.harmony_cafe

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harmony6.harmony_cafe.data.Menu
import java.time.LocalDate

class DetailActivity : AppCompatActivity() {
    private lateinit var components: List<Triple<ImageView, TextView, TextView>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.detail_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)

        initMenu()
        setComponents()
        setMenu("메뉴 이름 1")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    // 메뉴 구성 요소 위젯 초기화
    private fun setComponents() {
        components = arrayListOf(
            Triple(
                findViewById(R.id.detail_components1_img),
                findViewById(R.id.detail_components1_name),
                findViewById(R.id.detail_components1_desc)
            ),
            Triple(
                findViewById(R.id.detail_components2_img),
                findViewById(R.id.detail_components2_name),
                findViewById(R.id.detail_components2_desc)
            ),
            Triple(
                findViewById(R.id.detail_components3_img),
                findViewById(R.id.detail_components3_name),
                findViewById(R.id.detail_components3_desc)
            )
        )
    }

    // 메뉴 정보 표시
    private fun setMenu(menuName: String) {
        getMenuByMenuName(menuName)?.let { menu ->
            findViewById<ImageView>(R.id.detail_menu_img).apply { setImageResource(menu.img) }
            findViewById<TextView>(R.id.detail_menu_name).apply { text = menu.name }
            findViewById<TextView>(R.id.detail_user_name).apply { text = menu.username }
            findViewById<TextView>(R.id.detail_menu_created).apply {
                text = menu.createdDate.toString()
            }
            findViewById<TextView>(R.id.detail_menu_desc).apply { text = menu.desc }

            components.mapIndexed { idx, item ->
                item.first.setImageResource(menu.components[idx].img)
                item.first.clipToOutline = true
                item.second.text = menu.components[idx].name
                item.third.text = menu.components[idx].desc
            }
        }
    }

    // 메뉴 이름으로 메뉴 찾기
    private fun getMenuByMenuName(menuName: String): Menu? {
        return Menu.menuList.find { it.name == menuName }
    }

    // 메뉴 초기화
    private fun initMenu() {
        Menu(
            "메뉴 이름 1",
            "메뉴 설명 1", R.drawable.img_my_page_menu,
            "사용자 이름 1",
            LocalDate.of(2024, 1, 4),
            listOf(
                Menu.Components("메뉴 구성 이름 1", "메뉴 구성 설명 1", R.drawable.img_my_page_menu),
                Menu.Components("메뉴 구성 이름 2", "메뉴 구성 설명 2", R.drawable.img_my_page_menu),
                Menu.Components("메뉴 구성 이름 3", "메뉴 구성 설명 3", R.drawable.img_my_page_menu),
            )
        )
        Menu(
            "메뉴 이름 2",
            "메뉴 설명 2",
            R.drawable.img_my_page_menu,
            "사용자 이름 2",
            LocalDate.of(2001, 12, 24),
            listOf(
                Menu.Components("메뉴 구성 이름 1", "메뉴 구성 설명 1", R.drawable.img_my_page_menu),
                Menu.Components("메뉴 구성 이름 2", "메뉴 구성 설명 2", R.drawable.img_my_page_menu),
                Menu.Components("메뉴 구성 이름 3", "메뉴 구성 설명 3", R.drawable.img_my_page_menu),
            )
        )
        Menu(
            "메뉴 이름 3",
            "메뉴 설명 3",
            R.drawable.img_my_page_menu,
            "사용자 이름 3",
            LocalDate.of(2016, 10, 1),
            listOf(
                Menu.Components("메뉴 구성 이름 1", "메뉴 구성 설명 1", R.drawable.img_my_page_menu),
                Menu.Components("메뉴 구성 이름 2", "메뉴 구성 설명 2", R.drawable.img_my_page_menu),
                Menu.Components("메뉴 구성 이름 3", "메뉴 구성 설명 3", R.drawable.img_my_page_menu),
            )
        )
        Menu(
            "메뉴 이름 4",
            "메뉴 설명 4",
            R.drawable.img_my_page_menu,
            "사용자 이름 4",
            LocalDate.of(1995, 5, 5),
            listOf(
                Menu.Components("메뉴 구성 이름 1", "메뉴 구성 설명 1", R.drawable.img_my_page_menu),
                Menu.Components("메뉴 구성 이름 2", "메뉴 구성 설명 2", R.drawable.img_my_page_menu),
                Menu.Components("메뉴 구성 이름 3", "메뉴 구성 설명 3", R.drawable.img_my_page_menu),
            )
        )
    }
}