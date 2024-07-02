package com.harmony6.harmony_cafe

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogInActivity : AppCompatActivity() {

    //키를 아이디로 하는 해시맵으로 회원가입 유저 데이터들 관리
    val users=HashMap<String,User>()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editId=findViewById<EditText>(R.id.login_id)
        val editPw=findViewById<EditText>(R.id.login_password)

        val login=findViewById<Button>(R.id.login_loginbtn)
        val signup=findViewById<Button>(R.id.login_signupbtn)


        login.setOnClickListener{
            val id=editId.text.toString().trim()
            val pw=editPw.text.toString().trim()
            if(id.isEmpty()||pw.isEmpty()){
                Toast.makeText(this, "아이디와 패스워드 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(!users.keys.contains(id)){
                Toast.makeText(this, "가입되지 않은 아이디입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(users[id]!!.pass!=pw){
                Toast.makeText(this,"비밀번호를 다시 입력해주세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        }


        val launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result->
            if (result.resultCode == Activity.RESULT_OK){
                val user: User? =result.data!!.getParcelableExtra("user", User::class.java)
                if (user != null) {
                    users.put(user.id,user)
                }

            }
        }

        signup.setOnClickListener{
            launcher.launch(Intent(this,SignUpActivity::class.java))
        }

    }

}