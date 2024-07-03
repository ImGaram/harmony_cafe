package com.harmony6.harmony_cafe

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ids=intent.getStringArrayListExtra("ids")

        val toolbar = findViewById<Toolbar>(R.id.signup_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)


        val idEdit=findViewById<EditText>(R.id.signup_id)
        val pwEdit=findViewById<EditText>(R.id.signup_pw)
        val nameEdit=findViewById<EditText>(R.id.signup_name)
        val introduceEdit=findViewById<EditText>(R.id.signup_introduce)

        val dupBtn=findViewById<Button>(R.id.signup_dupbtn)
        val signupBtn=findViewById<Button>(R.id.signup_signupbtn)


        var idflag=false

        idEdit.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                idflag=false
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        dupBtn.setOnClickListener {
            val id=idEdit.text.toString()
            if(id.isEmpty()){
                Toast.makeText(this, getString(R.string.sginup_emptyid), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(id.contains(" ")){
                Toast.makeText(this, getString(R.string.sginup_idblank), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val idregex=Regex("^[a-zA-Z0-9$@!%*#?&]{1,}$") //알파벳 대소문자, 숫자, 특수문자
            if(id.contains(" ")||!idregex.matches(id)){
                Toast.makeText(this, getString(R.string.sginup_iderror), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(ids?.contains(id)?:false){
                Toast.makeText(this, getString(R.string.sginup_idassigned), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, getString(R.string.sginup_idok), Toast.LENGTH_SHORT).show()
            idflag=true
        }

        signupBtn.setOnClickListener {
            val pw=pwEdit.text.toString()
            val name=nameEdit.text.toString()
            val introduce=introduceEdit.text.toString()
            val id=idEdit.text.toString()

            if(!idflag){
                Toast.makeText(this, getString(R.string.sginup_dup), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(pw.isEmpty()||name.isEmpty()){
                Toast.makeText(this, getString(R.string.sginup_pwempty), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(pw.contains(" ")){
                Toast.makeText(this, getString(R.string.sginup_pwblank), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pwregex=Regex("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@!%*#?&.])[A-Za-z[0-9]$@!%*#?&.]{8,}\$")//영문 숫자 특수문자 전부 하나이상인 8자리 이상의 비밀번호
            if(pw.contains(" ")||!pwregex.matches(pw)){
                Toast.makeText(this, getString(R.string.sginup_pwerror), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent=Intent(this, LogInActivity::class.java)
            intent.putExtra("user",User(name,id,pw,introduce))
            setResult(RESULT_OK,intent)
            finish()
        }





    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId?:android.R.id.home){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}