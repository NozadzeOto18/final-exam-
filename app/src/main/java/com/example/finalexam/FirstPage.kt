package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first_page.*

class FirstPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)
        init()
    }
    private fun init (){
        SignInButton.setOnClickListener {
            val intent = Intent( this , SignInPage::class.java)
            startActivity(intent)
        }
        SignUpButton.setOnClickListener {
            val intent = Intent(this,SignUpPage::class.java)
            startActivity(intent)

        }


    }

}