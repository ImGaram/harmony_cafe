package com.harmony6.harmony_cafe

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harmony6.harmony_cafe.data.MenuObject

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userData = intent.getParcelableExtra<User>("user")
        val userNameText = findViewById<TextView>(R.id.my_page_text_user_name)
        val userIdText = findViewById<TextView>(R.id.my_page_text_user_id)
        val userIntroduceText = findViewById<TextView>(R.id.my_page_text_user_introduce)

        userNameText.text = userData?.name
        userIdText.text = userData?.id
        userIntroduceText.text = userData?.introduce

        var isMoreClicked = false
        userIntroduceText.setOnClickListener {
            if (userIntroduceText.lineCount == 1 && !isMoreClicked) {
                userIntroduceText.maxLines = 5
                isMoreClicked = true
            } else {
                userIntroduceText.maxLines = 1
                isMoreClicked = false
            }
        }

        val userMenu1 = findViewById<TextView>(R.id.my_page_text_user_menu1)
        val userMenu2 = findViewById<TextView>(R.id.my_page_text_user_menu2)
        val userMenu3 = findViewById<TextView>(R.id.my_page_text_user_menu3)

        userMenu1.text = getString(R.string.my_page_user_menu1, userData?.name)
        userMenu2.text = getString(R.string.my_page_user_menu2, userData?.name)
        userMenu3.text = getString(R.string.my_page_user_menu3, userData?.name)

        val backImage = findViewById<ImageView>(R.id.my_page_image_back)
        backImage.setOnClickListener { finish() }

        val menuList = MenuObject.menuList
        val numList = (0..4).toList()
        val randomMenu = numList.shuffled().take(3)

        val menuName1 = findViewById<TextView>(R.id.my_page_text_menu_name1)
        val menuName2 = findViewById<TextView>(R.id.my_page_text_menu_name2)
        val menuName3 = findViewById<TextView>(R.id.my_page_text_menu_name3)

        menuName1.text = menuList[randomMenu[0]].name
        menuName2.text = menuList[randomMenu[1]].name
        menuName3.text = menuList[randomMenu[2]].name

        val menuImage1 = findViewById<ImageView>(R.id.my_page_image_menu1)
        val menuImage2 = findViewById<ImageView>(R.id.my_page_image_menu2)
        val menuImage3 = findViewById<ImageView>(R.id.my_page_image_menu3)

        menuImage1.setImageResource(menuList[randomMenu[0]].img)
        menuImage2.setImageResource(menuList[randomMenu[1]].img)
        menuImage3.setImageResource(menuList[randomMenu[2]].img)

        val menuDescription1 = findViewById<TextView>(R.id.my_page_text_menu_description1)
        val menuDescription2 = findViewById<TextView>(R.id.my_page_text_menu_description2)
        val menuDescription3 = findViewById<TextView>(R.id.my_page_text_menu_description3)

        menuDescription1.text = menuList[randomMenu[0]].desc
        menuDescription2.text = menuList[randomMenu[1]].desc
        menuDescription3.text = menuList[randomMenu[2]].desc
    }
}