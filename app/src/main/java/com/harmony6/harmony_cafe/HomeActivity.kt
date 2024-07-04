package com.harmony6.harmony_cafe

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.snackbar.Snackbar
import com.harmony6.harmony_cafe.data.MenuObject
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


        val menuList = MenuObject.menuList
        val numList = (0..4).toList()
        val randomNum = numList.shuffled()

        val lottie = findViewById<LottieAnimationView>(R.id.lottie)

        val appLogo = findViewById<TextView>(R.id.home_app_name)
        // Horizontal ScrollView 메뉴
        val detailImage1 = findViewById<ImageView>(R.id.home_imageView1)
        val detailImage2 = findViewById<ImageView>(R.id.home_imageView2)
        val detailImage3 = findViewById<ImageView>(R.id.home_imageView3)
        val detailImage4 = findViewById<ImageView>(R.id.home_imageView4)
        val detailImage5 = findViewById<ImageView>(R.id.home_imageView5)
        detailImage1.setImageResource(menuList[randomNum[0]].img)
        detailImage2.setImageResource(menuList[randomNum[1]].img)
        detailImage3.setImageResource(menuList[randomNum[2]].img)
        detailImage4.setImageResource(menuList[randomNum[3]].img)
        detailImage5.setImageResource(menuList[randomNum[4]].img)

        lottie.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {}

            override fun onAnimationEnd(animation: Animator, isReverse: Boolean) {}

            override fun onAnimationEnd(p0: Animator) {}

            override fun onAnimationCancel(p0: Animator) {}

            override fun onAnimationRepeat(p0: Animator) {}
        })

        appLogo.setOnLongClickListener {
            Toast.makeText(this,"꾸우우욱", Toast.LENGTH_SHORT).show()
            lottie.visibility = View.VISIBLE
            lottie.playAnimation()
            return@setOnLongClickListener(true)
        }


        // 앱바 views
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
        fun putIntent(detailNum: Int){
            when(detailNum){
                0 -> {
                    detailIntent.putExtra("menuKey", menuList[randomNum[0]].name)
                    startActivity(detailIntent)
                }
                1 -> {
                    detailIntent.putExtra("menuKey", menuList[randomNum[1]].name)
                    startActivity(detailIntent)
                }
                2 -> {
                    detailIntent.putExtra("menuKey", menuList[randomNum[2]].name)
                    startActivity(detailIntent)
                }
                3 -> {
                    detailIntent.putExtra("menuKey", menuList[randomNum[3]].name)
                    startActivity(detailIntent)
                }
                4 -> {
                    detailIntent.putExtra("menuKey", menuList[randomNum[4]].name)
                    startActivity(detailIntent)
                }
            }
        }

        detailImage1.setOnClickListener{putIntent(0)}
        detailImage2.setOnClickListener{putIntent(1)}
        detailImage3.setOnClickListener{putIntent(2)}
        detailImage4.setOnClickListener{putIntent(3)}
        detailImage5.setOnClickListener{putIntent(4)}
    }
}