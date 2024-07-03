package com.harmony6.harmony_cafe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.harmony6.harmony_cafe.data.MenuObject.initMenu

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initMenu()      // 메뉴 초기화

        val detailImage1 = findViewById<ImageView>(R.id.home_imageView1)
        val detailImage2 = findViewById<ImageView>(R.id.home_imageView2)
        val detailImage3 = findViewById<ImageView>(R.id.home_imageView3)
        val detailImage4 = findViewById<ImageView>(R.id.home_imageView4)
        val detailImage5 = findViewById<ImageView>(R.id.home_imageView5)
        val nameTextView = findViewById<TextView>(R.id.home_welcome_message)
        val myPageImageButton = findViewById<ImageView>(R.id.imageButton)

        val snackBar = Snackbar.make(findViewById(R.id.main), getString(R.string.home_snackbar), Snackbar.LENGTH_SHORT)
        snackBar.show()

        val userData = intent.getParcelableExtra<User>("user")
        nameTextView.text = getString(R.string.home_welcome_message, userData?.name)

        val myPageIntent = Intent(this, MyPageActivity::class.java)
        myPageImageButton.setOnClickListener{
            myPageIntent.putExtra("user", userData)
            startActivity(myPageIntent)
        }


        val detailIntent = Intent(this, DetailActivity::class.java)

//        Log.d("Home log!", "asfxdfasdfasdf") << 나중에 제가 삭제할게요
        fun putIntent(detailNum: Int){
            when(detailNum){
                1 -> {
                    detailIntent.putExtra("menuKey", getString(R.string.menu_name1))
                    startActivity(detailIntent)
                }
                2 -> {
                    detailIntent.putExtra("menuData", getString(R.string.menu_name2))
                    startActivity(detailIntent)
                }
                3 -> {
                    detailIntent.putExtra("menuData", getString(R.string.menu_name3))
                    startActivity(detailIntent)
                }
                4 -> {
                    detailIntent.putExtra("menuData", getString(R.string.menu_name4))
                    startActivity(detailIntent)
                }
                5 -> {
                    detailIntent.putExtra("menuData", getString(R.string.menu_name5))
                    startActivity(detailIntent)
                }
            }
        }

        detailImage1.setOnClickListener{putIntent(1)}
        detailImage2.setOnClickListener{putIntent(2)}
        detailImage3.setOnClickListener{putIntent(3)}
        detailImage4.setOnClickListener{putIntent(4)}
        detailImage5.setOnClickListener{putIntent(5)}
    }
}