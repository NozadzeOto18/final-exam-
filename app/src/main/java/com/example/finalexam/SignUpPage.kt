package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up_page.*

class SignUpPage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)
        init()
    }
    private fun init() {
        auth = Firebase.auth
        SignUpButton.setOnClickListener() {
            signUp()
        }
    }
    private fun signUp() {
        val emailET = emailEditText.text.toString()
        val passwordET = passwordEditText.text.toString()
        val repeatPassET = repeatPasswordEditText.text.toString()
        if (emailET.isNotEmpty() && passwordET.isNotEmpty() && repeatPassET.isNotEmpty()) {
            if (passwordET == repeatPassET) {
                auth.createUserWithEmailAndPassword(emailET, passwordET)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            Toast.makeText(this, "Authentication passed", Toast.LENGTH_SHORT).show()
                            progressBar.visibility=View.VISIBLE
                            val intent = Intent(this, SignInPage()::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please repeat password correctly!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
        }
    }
}