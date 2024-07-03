package com.harmony6.harmony_cafe

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val detailImage1 = findViewById<ImageView>(R.id.home_imageView1)
        val detailImage2 = findViewById<ImageView>(R.id.home_imageView2)
        val detailImage3 = findViewById<ImageView>(R.id.home_imageView3)
        val detailImage4 = findViewById<ImageView>(R.id.home_imageView4)
        val detailImage5 = findViewById<ImageView>(R.id.home_imageView5)
        val nameTextView = findViewById<TextView>(R.id.home_welcome_message)
        val myPageImageButton = findViewById<ImageView>(R.id.imageButton)

        val userData = intent.getParcelableExtra<User>("user")
        nameTextView.text = getString(R.string.home_welcome_message, userData?.name)

        myPageImageButton.setOnClickListener{
            val myPageIntent = Intent(this, MyPageActivity::class.java)
            myPageIntent.putExtra("user", userData)
            startActivity(myPageIntent)
        }

    }
}