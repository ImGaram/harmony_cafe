package com.harmony6.harmony_cafe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harmony6.harmony_cafe.data.Menu
import com.harmony6.harmony_cafe.data.MenuObject

class DetailActivity : AppCompatActivity() {
    private lateinit var components: List<List<View>>
    private var delay = 0L

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

        val menuName = intent.getStringExtra("menuKey") ?: ""
        val menu = MenuObject.findMenuByName(menuName)

        setComponents()
        setMenu(menu)

        findViewById<ImageView>(R.id.detail_menu_img).setOnClickListener {
            if (System.currentTimeMillis() > delay) {
                delay = System.currentTimeMillis() + 200
                return@setOnClickListener
            } else {
                menu?.let { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it.site))) }
            }
        }
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
            listOf(
                findViewById(R.id.detail_components1_img),
                findViewById(R.id.detail_components1_name),
                findViewById(R.id.detail_components1_desc),
                findViewById(R.id.detail_components1_desc_more)
            ),
            listOf(
                findViewById(R.id.detail_components2_img),
                findViewById(R.id.detail_components2_name),
                findViewById(R.id.detail_components2_desc),
                findViewById(R.id.detail_components2_desc_more)
            )
        )
    }

    // 메뉴 정보 표시
    private fun setMenu(menu: Menu?) {
        menu?.let {
            findViewById<ImageView>(R.id.detail_menu_img).apply { setImageResource(menu.img) }
            findViewById<TextView>(R.id.detail_menu_name).apply {
                text = menu.name
                post {
                    if (layout.getEllipsisCount(lineCount - 1) > 0) {
                        maxLines = Int.MAX_VALUE
                        handleLayout()
                    }
                }
            }
            findViewById<TextView>(R.id.detail_user_name).text.apply { menu.username }
            findViewById<TextView>(R.id.detail_menu_created).text.apply { menu.createdDate.toString() }
            findViewById<TextView>(R.id.detail_menu_desc).setMoreBtn(
                findViewById(R.id.detail_desc_more),
                menu.desc
            )
            components.mapIndexed { idx, item ->
                (item[0] as ImageView).setImageResource(menu.components[idx].img)
                item[0].clipToOutline = true
                (item[1] as TextView).text = menu.components[idx].name
                (item[2] as TextView).setMoreBtn(item[3] as TextView, menu.components[idx].desc, 2)
            }
        }
    }

    private fun handleLayout() {
        val menuName = findViewById<TextView>(R.id.detail_menu_name)
        menuName.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            startToStart = R.id.detail_menu_img
            topToBottom = R.id.detail_menu_img
            endToEnd = R.id.detail_menu_img
            setMargins(dpToPx(16f), dpToPx(16f), dpToPx(16f), dpToPx(8f))
        }

        val userInfo = findViewById<LinearLayout>(R.id.detail_user_info)
        userInfo.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            startToStart = R.id.detail_menu_img
            topToBottom = R.id.detail_menu_name
            setMargins(dpToPx(16f), 0, dpToPx(8f), 0)
        }
    }

    // 더보기/접기 버튼 설정
    private fun TextView.setMoreBtn(btn: TextView, desc: String, maxLine: Int = 3) {
        text = desc
        post {
            if (layout.lineCount > maxLine - 1 && layout.getEllipsisCount(lineCount - 1) > 0) {
                btn.visibility = View.VISIBLE
                btn.setOnClickListener {
                    btn.text =
                        if (maxLines == maxLine) getString(R.string.fold) else getString(
                            R.string.more
                        )
                    maxLines = if (maxLines == maxLine) Int.MAX_VALUE else maxLine
                }
            } else btn.visibility = View.GONE
        }
    }

    // dp to px
    private fun dpToPx(dp: Float) =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()
}