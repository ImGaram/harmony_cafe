package com.harmony6.harmony_cafe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harmony6.harmony_cafe.data.Menu
import com.harmony6.harmony_cafe.data.MenuObject

class DetailActivity : AppCompatActivity() {
    private lateinit var components: List<Triple<ImageView, TextView, TextView>>

    var delay = 0L
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
        val menu = getMenuByMenuName(menuName)

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
            Triple(
                findViewById(R.id.detail_components1_img),
                findViewById(R.id.detail_components1_name),
                findViewById(R.id.detail_components1_desc)
            ),
            Triple(
                findViewById(R.id.detail_components2_img),
                findViewById(R.id.detail_components2_name),
                findViewById(R.id.detail_components2_desc)
            )
        )
    }

    // 메뉴 정보 표시
    private fun setMenu(menu: Menu?) {
        menu?.let {
            findViewById<ImageView>(R.id.detail_menu_img).apply { setImageResource(menu.img) }
            findViewById<TextView>(R.id.detail_menu_name).apply { text = menu.name }
            findViewById<TextView>(R.id.detail_user_name).apply { text = menu.username }
            findViewById<TextView>(R.id.detail_menu_created).apply {
                text = menu.createdDate.toString()
            }
            findViewById<TextView>(R.id.detail_menu_desc).apply {
                setEllipsis(this, menu.desc)

                setOnClickListener {
                    setEllipsis(this, menu.desc)
                }
            }

            components.mapIndexed { idx, item ->
                item.first.setImageResource(menu.components[idx].img)
                item.first.clipToOutline = true
                item.second.text = menu.components[idx].name
                item.third.text = menu.components[idx].desc
            }
        }
    }

    // 메뉴 이름으로 메뉴 찾기
    private fun getMenuByMenuName(name: String) = MenuObject.menuList.find { it.name == name }

    private fun setEllipsis(view: TextView, text: String, maxLine: Int = 3) {
        view.text = text

        view.post {
            if (view.lineCount >= maxLine) {
                val sourceString: String
                val suffix: String
                val lineEndIndex = view.layout.getLineVisibleEnd(maxLine - 1)

                if (view.tag == null || view.tag.toString()
                        .contains(getString(R.string.detail_fold))
                ) {
                    suffix = getString(R.string.detail_more)
                    val shortenedText = text.substring(0, lineEndIndex - suffix.length)
                    sourceString = shortenedText + suffix
                } else {
                    suffix = getString(R.string.detail_fold)
                    sourceString = text + suffix
                }

                val spannableString = SpannableString(sourceString)

                spannableString.setSpan(
                    ForegroundColorSpan(resources.getColor(R.color.highlight, theme)),
                    spannableString.length - suffix.length,
                    spannableString.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )

                view.tag = spannableString
                view.text = spannableString
            }
        }
    }
}