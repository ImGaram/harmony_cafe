package com.harmony6.harmony_cafe

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogInActivity : AppCompatActivity() {

    //키를 아이디로 하는 해시맵으로 회원가입 유저 데이터들 관리
    val users=HashMap<String,User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        users.put("1",User("1","1","1","1"))

        val editId=findViewById<EditText>(R.id.login_id)
        val editPw=findViewById<EditText>(R.id.login_password)

        val login=findViewById<Button>(R.id.login_loginbtn)
        val signup=findViewById<Button>(R.id.login_signupbtn)


        login.setOnClickListener{
            val id=editId.text.toString()
            val pw=editPw.text.toString()
            if(id.isEmpty()||pw.isEmpty()){
                Toast.makeText(this, getString(R.string.login_empty), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(!users.keys.contains(id)){
                Toast.makeText(this, getString(R.string.login_iderror), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(users[id]!!.pass!=pw){
                Toast.makeText(this,getString(R.string.login_pwerror),Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent=Intent(this, HomeActivity::class.java)
            intent.putExtra("user",users[id])
            startActivity(intent)
        }


        val launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result->
            if (result.resultCode == Activity.RESULT_OK){
                val user=result.data?.getParcelableExtra("user",User::class.java)
                if (user != null) {
                    users.put(user.id,user)
                }

            }
        }

        signup.setOnClickListener{
            val intent=Intent(this,SignUpActivity::class.java)
            intent.putStringArrayListExtra("ids",ArrayList(users.keys))
            launcher.launch(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("체크","1")
    }

}